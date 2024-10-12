package energy.dubhacks.reliefApp.service;

import java.util.List;

import energy.dubhacks.reliefApp.model.Post;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvideService {
    private ResourceRepository resourceRepository;

    public List<Post> getAllPosts() {
        return resourceRepository.findAll();
    }
}
