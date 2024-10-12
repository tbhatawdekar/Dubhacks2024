package energy.dubhacks.reliefApp.repository;

import java.util.ArrayList;
import java.util.List;

import energy.dubhacks.reliefApp.model.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepository {

    private List<Resource> resources;

    public ResourceRepository() {}

    public List<Resource> findAll() {
        return resources;
    }

    public Object findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
