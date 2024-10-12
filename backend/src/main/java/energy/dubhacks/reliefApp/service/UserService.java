package energy.dubhacks.reliefApp.service;

import java.util.List;

import energy.dubhacks.reliefApp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import energy.dubhacks.reliefApp.dto.UserDTO;
import energy.dubhacks.reliefApp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<Post> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public Post getUserById(Long id) {
        return null;
    }

    // Create a new user
    public Post createUser(UserDTO userDTO) {
        Post post = new Post();
        post.setUsername(userDTO.getUsername());
        post.setEmail(userDTO.getEmail());
        // Set other fields as necessary
        return userRepository.save(post);
    }

    // Update an existing user
    public Post updateUser(Long id, UserDTO userDTO) {
        Post existingPost = getUserById(id);
        existingPost.setUsername(userDTO.getUsername());
        existingPost.setEmail(userDTO.getEmail());
        // Update other fields as necessary
        return userRepository.save(existingPost);
    }

    // Delete a user
    public void deleteUser(Long id) {
        Post post = getUserById(id);
        userRepository.delete(post);
    }

    public List<Post> getAllPosts() {
        return null;
    }
}
