package tech.topnews.blog.controllers.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.topnews.blog.entities.Post;
import tech.topnews.blog.services.PostService;
import tech.topnews.blog.services.UserService;

import java.util.Date;

@Controller("adminPostController")
public class PostController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public void setPostService(PostService postService){
        this.postService = postService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("admin/post/create")
    public String create(Model model){
        model.addAttribute("pageTitle", "Добавить пост");
        model.addAttribute("model", new Post());

        return "backend/post/create";
    }

    @GetMapping("admin/post")
    public String index(Model model){
        model.addAttribute("pageTitle", "Список публикаций");
        model.addAttribute("posts", postService.findAll());
        return "backend/post/index";
    }

    @PostMapping("admin/post")
    public String save(Post post){
        post.setCreated_at(new Date());
        post.setUser(userService.findById(1L));
        post.setLanguage("RU");
        postService.create(post);

        return "redirect:/admin";
    }
}
