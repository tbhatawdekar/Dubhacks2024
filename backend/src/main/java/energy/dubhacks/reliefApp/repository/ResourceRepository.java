package energy.dubhacks.reliefApp.repository;

import java.util.List;

import energy.dubhacks.reliefApp.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepository {

    private List<Post> resources;

    public ResourceRepository() {}

    public List<Post> findAll() {
        return resources;
    }

    public Object findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
