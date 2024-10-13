package energy.dubhacks.reliefApp.service;

import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

//    // Retrieve all resources
//    public List<Resource> getAllResources() {
//        return resourceRepository.findAll();
//    }

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
                        Map.of("role", "user", "content", "Please read and parse this post about hurricane" +
                                "relief The post is the last sentence in this message. Decide whether or not it fits into these tags: Food, Shelter, Immediate attention. " +
                                "Only give a short summary of what they said, and give what tags it satisfies out of the 3 tags" +
                                "HELP, MY HOUSE IS ON FIRE BECAUSE OF THE HURRICANE")
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
        System.out.println(re);
        return new Resource(re);
    }

    // Update an existing resource
    public Resource updateResource(Long id, SeekPostDTO seekPostDTO) {
        return null;
    }

    // Delete a resource
    public void deleteResource(Long id) {
        
    }
}
