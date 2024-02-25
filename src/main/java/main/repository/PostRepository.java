package main.repository;

import main.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();
}
