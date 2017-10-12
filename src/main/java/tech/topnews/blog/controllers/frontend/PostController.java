package tech.topnews.blog.controllers.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.topnews.blog.entities.Post;
import tech.topnews.blog.services.NotificationService;
import tech.topnews.blog.services.PostService;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @GetMapping("post/{id}/{type}")
    public String view(@PathVariable Long id, @PathVariable String type, Model model){
        Post post = postService.findById(id);

        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }

        model.addAttribute("post", post);
        model.addAttribute("type", type);
        return "frontend/post/view";
    }
}
