package main.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Post;
import main.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepoImpl implements PostRepository {
    private final EntityManager entityManager;
    @Override
    public List<Post> getAllPosts() {
        return entityManager.createQuery("select p from Post p").getResultList();
    }
}
