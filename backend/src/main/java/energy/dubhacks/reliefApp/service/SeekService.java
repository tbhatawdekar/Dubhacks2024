package energy.dubhacks.reliefApp.service;

import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Post;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
public class SeekService {

    private final ResourceRepository resourceRepository;
    private final WebClient webClient;

    @Autowired
    public SeekService(ResourceRepository resourceRepository, WebClient.Builder webClientBuilder) {
        this.resourceRepository = new ResourceRepository();
        this.webClient = webClientBuilder.build();
    }

    // Create a new resource
    public Post createResource(SeekPostDTO seekPostDTO) throws IOException {
        String prompt = Files.readString(Path.of(new ClassPathResource("static/perplexitySeekPrompt.txt").getURI()));
        Map<String, Object> requestBody = Map.of(
                "model", "llama-3.1-sonar-small-128k-online",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Be precise and concise."),
                        Map.of("role", "user", "content", prompt +
                                seekPostDTO.getMessage())
                }
        );
        Mono<String> apiResponse = (webClient.post()
                .uri("https://api.perplexity.ai/chat/completions")
                .header("Authorization", "")
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class));
        String re = apiResponse.block();
        //TODO: parse JSON and populate summary, categoriesToTags, Urgency
        return new Post(re, seekPostDTO.getMessage(), null, false   );
    }
}
