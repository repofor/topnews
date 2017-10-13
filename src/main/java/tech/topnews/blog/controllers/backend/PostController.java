package tech.topnews.blog.controllers.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.topnews.blog.entities.Post;
import tech.topnews.blog.services.PostService;


@Controller("adminPostController")
public class PostController {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService){
        this.postService = postService;
    }

    @GetMapping("admin/post")
    public String index(Model model){
        model.addAttribute("pageTitle", "Список публикаций");
        model.addAttribute("posts", postService.findAll());
        return "backend/post/index";
    }

    @GetMapping("admin/post/form")
    public String create(Model model){
        model.addAttribute("pageTitle", "Добавить пост");
        model.addAttribute("model", new Post());

        return "backend/post/form";
    }

    @PostMapping("admin/post")
    public String save(Post post){
        postService.save(post);

        return "redirect:/admin";
    }
}
