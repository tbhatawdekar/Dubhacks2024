package energy.dubhacks.reliefApp.service;

import energy.dubhacks.reliefApp.dto.SeekPostDTO;
import energy.dubhacks.reliefApp.model.Post;
import energy.dubhacks.reliefApp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SeekService {

    private ResourceRepository resourceRepository;

    @Autowired
    public SeekService(ResourceRepository resourceRepository, WebClient.Builder webClientBuilder) {
        this.resourceRepository = new ResourceRepository();
    }

    // Create a new resource
    public Post createResource(SeekPostDTO seekPostDTO) {
        return null;
    }
}
