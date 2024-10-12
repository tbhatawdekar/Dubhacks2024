package energy.dubhacks.reliefApp.controller;

import energy.dubhacks.reliefApp.dto.ResourceDTO;
import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Resource;
import energy.dubhacks.reliefApp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seek")
public class SeekHelpController {

    @Autowired
    private ResourceService resourceService;

    // Create a new post
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody SeekPostDTO seekPostDTO) {
        Resource createdResource = resourceService.createResource(seekPostDTO);
        return ResponseEntity.ok(createdResource);
    }

    // // Update an existing post
    // @PutMapping("/{id}")
    // public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody ResourceDTO resourceDTO) {
    //     Resource updatedResource = resourceService.updateResource(id, resourceDTO);
    //     return ResponseEntity.ok(updatedResource);
    // }

    // // Delete a post
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
    //     resourceService.deleteResource(id);
    //     return ResponseEntity.noContent().build();
    // }
}
