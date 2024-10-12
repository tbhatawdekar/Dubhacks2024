package energy.dubhacks.reliefApp.service;

import energy.dubhacks.reliefApp.dto.ResourceDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
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
    public Resource createResource(ResourceDTO resourceDTO) {
        return null;
    }

    // Update an existing resource
    public Resource updateResource(Long id, ResourceDTO resourceDTO) {
        return null;
    }

    // Delete a resource
    public void deleteResource(Long id) {
        
    }
}
