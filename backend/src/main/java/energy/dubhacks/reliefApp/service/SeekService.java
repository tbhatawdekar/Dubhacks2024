package energy.dubhacks.reliefApp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Post;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeekService {

    private final ResourceRepository resourceRepository;
    private final WebClient webClient;

    @Value("${api.auth}")
    private String apiAuth;

    @Autowired
    public SeekService(ResourceRepository resourceRepository, WebClient.Builder webClientBuilder) {
        this.resourceRepository = new ResourceRepository();
        this.webClient = webClientBuilder.build();
    }

    // Create a new resource
    public Post createPost(SeekPostDTO seekPostDTO) throws IOException {
        String prompt = Files.readString(Path.of(new ClassPathResource("static/perplexitySeekPrompt.txt").getURI()));
        Map<String, Object> requestBody = Map.of(
                "model", "llama-3.1-sonar-small-128k-online",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Be precise and concise."),
                        Map.of("role", "user", "content", prompt +
                                seekPostDTO.getMessage())
                }
        );
        Mono<JsonNode> apiResponse = (webClient.post()
                .uri("https://api.perplexity.ai/chat/completions")
                .header("Authorization", apiAuth)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(JsonNode.class));

        JsonNode node = apiResponse.block();
        String value = "";
        ObjectMapper objectMapper = new ObjectMapper();

        if (node != null) {
            value = node.get("choices").get(0).get("message").get("content").textValue();
            value = value.substring(value.indexOf("{"), value.lastIndexOf("}") + 1);
            // Parse JSON string into a JsonNode
            node = objectMapper.readTree(value);
        }

        Map<String, List<String>> categoriesToTags = new HashMap<>();
        categoriesToTags.put("Food", objectMapper.convertValue(node.get("Food"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Manpower", objectMapper.convertValue(node.get("Manpower"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Medical", objectMapper.convertValue(node.get("Medical"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Petcare", objectMapper.convertValue(node.get("Petcare"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Shelter", objectMapper.convertValue(node.get("Shelter"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Transportation", objectMapper.convertValue(node.get("Transportation"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Water", objectMapper.convertValue(node.get("Water"), new TypeReference<List<String>>() {}));
        categoriesToTags.put("Emotional Support", objectMapper.convertValue(node.get("Emotional Support"), new TypeReference<List<String>>() {}));

        //TODO: parse JSON and populate summary, categoriesToTags, Urgency
        Post newPost = new Post(
                node.get("Summary").asText(),
                seekPostDTO.getMessage(),
                categoriesToTags,
                node.get("Urgency").asBoolean());

        return newPost;
    }
}
