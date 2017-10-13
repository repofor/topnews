package tech.topnews.blog.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.topnews.blog.entities.Post;
import tech.topnews.blog.repositories.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    @Autowired
    public void setPostRepo(PostRepository postRepo) {
        this.postRepo = postRepo;
    }


    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        return this.postRepo.findLatest5Posts(new PageRequest(0, 5));
    }

    @Override
    public Post findById(Long id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public Post save(Post post) {
        if (post.getId() == null){
            post.setCreatedAt(new Date());
            post.setUser(userService.findById(1L));
            post.setLanguage("RU");
        }
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepo.delete(id);
    }
}
