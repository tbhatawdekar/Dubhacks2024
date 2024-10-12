package energy.dubhacks.reliefApp.controller;

import energy.dubhacks.reliefApp.model.Post;
import energy.dubhacks.reliefApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/provide")
public class ProvideHelpController {

    @Autowired
    private UserService userService;

    // Gets all posts
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> users = userService.getAllPosts();
        return ResponseEntity.ok(users);
    }
}
