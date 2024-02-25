package main.service.servImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.entity.Post;
import main.repository.PostRepository;
import main.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }
}
