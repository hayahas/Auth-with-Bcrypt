package com.Ltuc.BcryptProj.controllers;


import com.Ltuc.BcryptProj.repositries.NewUserRepositry;
import com.Ltuc.BcryptProj.repositries.PostsRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WelcomeController {

    @Autowired
    NewUserRepositry newUserRepositry;
    @Autowired
    PostsRepositry PostsRepositry;

    @PostMapping("/signupFromWelcome")
    public RedirectView ToSignupPage(){

        return new RedirectView("/signup");
    }


    @PostMapping("/loginFromWelcome")
    public RedirectView ToLoginPage(){

        return new RedirectView("/login");
    }

    @GetMapping("/")
    public String welcomePage(){
        return "WelcomePage.html";
    }


}
