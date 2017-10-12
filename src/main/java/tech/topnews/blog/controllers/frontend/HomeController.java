package tech.topnews.blog.controllers.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.topnews.blog.entities.Post;
import tech.topnews.blog.services.PostService;

import java.util.List;

@Controller
public class HomeController {
    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Post> latesPosts = postService.findLatest5();

        model.addAttribute("latestPosts", latesPosts);
        return "frontend/home/index";
    }
}
