package energy.dubhacks.reliefApp.repository;

import java.util.ArrayList;
import java.util.List;

import energy.dubhacks.reliefApp.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepository {

    private static List<Post> resources;

    public ResourceRepository(ArrayList<Post> resources) {
        this.resources = resources;
    }

    public List<Post> findAll() {
        return resources;
    }

    public void addPost(Post post) {
        resources.add(post);
    }
}
