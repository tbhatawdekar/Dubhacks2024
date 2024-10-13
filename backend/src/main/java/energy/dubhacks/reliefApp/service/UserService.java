//package energy.dubhacks.reliefApp.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import energy.dubhacks.reliefApp.dto.UserDTO;
//import energy.dubhacks.reliefApp.model.User;
//import energy.dubhacks.reliefApp.repository.UserRepository;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Retrieve all users
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    // Retrieve a user by ID
//    public User getUserById(Long id) {
//        return null;
//    }
//
//    // Create a new user
//    public User createUser(UserDTO userDTO) {
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        // Set other fields as necessary
//        return userRepository.save(user);
//    }
//
//    // Update an existing user
//    public User updateUser(Long id, UserDTO userDTO) {
//        User existingUser = getUserById(id);
//        existingUser.setUsername(userDTO.getUsername());
//        existingUser.setEmail(userDTO.getEmail());
//        // Update other fields as necessary
//        return userRepository.save(existingUser);
//    }
//
//    // Delete a user
//    public void deleteUser(Long id) {
//        User user = getUserById(id);
//        userRepository.delete(user);
//    }
//}
