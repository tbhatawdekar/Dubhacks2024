package energy.dubhacks.reliefApp.service;

import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
public class ResourceService {

    private ResourceRepository resourceRepository;
    private WebClient webClient;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository, WebClient.Builder webClientBuilder) {
        this.resourceRepository = new ResourceRepository();
        this.webClient = webClientBuilder.build();
    }

    // Retrieve all resources
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    // Retrieve a resource by ID
    public Resource getResourceById(Long id) {
        return null;
    }

    // Create a new resource
    public Resource createResource(SeekPostDTO seekPostDTO) {
        Map<String, Object> requestBody = Map.of(
                "model", "llama-3.1-sonar-small-128k-online",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Be precise and concise."),
                        Map.of("role", "user", "content", "How many stars are there in our galaxy?")
                }
        );
        String apiResponse = String.valueOf(webClient.post()
                .uri("https://api.perplexity.ai/chat/completions")
                .header("Authorization", "Bearer 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")
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class));

        System.out.println(apiResponse);
        return new Resource(apiResponse);
    }

    // Update an existing resource
    public Resource updateResource(Long id, SeekPostDTO seekPostDTO) {
        return null;
    }

    // Delete a resource
    public void deleteResource(Long id) {
        
    }
}
