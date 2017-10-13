package tech.topnews.blog.services;

import tech.topnews.blog.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post save(Post post);
    void deleteById(Long id);
}
