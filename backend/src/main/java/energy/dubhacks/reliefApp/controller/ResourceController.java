package energy.dubhacks.reliefApp.controller;

import energy.dubhacks.reliefApp.dto.ResourceDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // Get all resources
    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    // Get a resource by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = resourceService.getResourceById(id);
        return ResponseEntity.ok(resource);
    }

    // Create a new resource
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody ResourceDTO resourceDTO) {
        Resource createdResource = resourceService.createResource(resourceDTO);
        return ResponseEntity.ok(createdResource);
    }

    // Update an existing resource
    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody ResourceDTO resourceDTO) {
        Resource updatedResource = resourceService.updateResource(id, resourceDTO);
        return ResponseEntity.ok(updatedResource);
    }

    // Delete a resource
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }
}
