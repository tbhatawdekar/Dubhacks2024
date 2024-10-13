package energy.dubhacks.reliefApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class ResourceService {

    private ResourceRepository resourceRepository;
    private WebClient webClient;

    @Value("${api.auth}")
    private String apiAuth;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository, WebClient.Builder webClientBuilder) {
        this.resourceRepository = new ResourceRepository();
        this.webClient = webClientBuilder.build();
    }

    // Retrieve all resources
//    public List<Resource> getAllResources() {
//        return resourceRepository.findAll();
//    }

    // Retrieve a resource by ID
    public Resource getResourceById(Long id) {
        return null;
    }

    // Create a new resource
    public Resource createResource(SeekPostDTO seekPostDTO) throws JsonProcessingException {
        Map<String, Object> requestBody = Map.of(
                "model", "llama-3.1-sonar-small-128k-online",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Be precise and concise."),
                        Map.of("role", "user", "content", "Please read and parse this post about hurricane" +
                                "relief The post is the last sentence in this message. Decide whether or not it fits into these tags: Food, Shelter, Immediate attention. " +
                                "give a response in json with three fields, each representing the 3 tags with a boolean" +
                                "HELP, MY HOUSE IS ON FIRE BECAUSE OF THE HURRICANE")
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
        if (node != null) {
            value = node.get("choices").get(0).get("message").get("content").textValue();
            value = value.substring(value.indexOf("{"), value.lastIndexOf("}") + 1);
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON string into a JsonNode
            node = objectMapper.readTree(value);
        }


        return new Resource("hi");
    }

    // Update an existing resource
    public Resource updateResource(Long id, SeekPostDTO seekPostDTO) {
        return null;
    }

    // Delete a resource
    public void deleteResource(Long id) {
        
    }
}
