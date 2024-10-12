package energy.dubhacks.reliefApp.controller;

import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Post;
import energy.dubhacks.reliefApp.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seek")
public class SeekHelpController {

    @Autowired
    private SeekService seekService;

    // Create a new post
    @PostMapping
    public ResponseEntity<Post> createResource(@RequestBody SeekPostDTO seekPostDTO) {
        Post createdResource = seekService.createResource(seekPostDTO);
        return ResponseEntity.ok(createdResource);
    }

    // Update an existing post?

    // Delete a post?

}
