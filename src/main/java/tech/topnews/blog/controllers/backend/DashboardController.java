package tech.topnews.blog.controllers.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {


    @GetMapping("admin")
    public String index(){
        return "redirect:/admin/post";
    }
}
