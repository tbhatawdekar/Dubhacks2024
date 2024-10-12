package energy.dubhacks.reliefApp.service;

import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

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
        return null;
    }

    // Update an existing resource
    public Resource updateResource(Long id, SeekPostDTO seekPostDTO) {
        return null;
    }

    // Delete a resource
    public void deleteResource(Long id) {
        
    }
}
