package tech.topnews.blog.controllers.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.topnews.blog.forms.backend.LoginForm;
import tech.topnews.blog.services.NotificationService;
import tech.topnews.blog.services.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @Autowired
    private NotificationService notifyService;

    @GetMapping("/admin/login")
    public String login(LoginForm loginForm) {
        return "backend/login/login";
    }

    @PostMapping(value = "/admin/login")
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "backend/login/login";
        }

        if (!userService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "backend/login/login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}
