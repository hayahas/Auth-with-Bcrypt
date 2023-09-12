package com.Ltuc.BcryptProj.controllers;

import com.Ltuc.BcryptProj.exceptions.PostsNotFound;
import com.Ltuc.BcryptProj.models.NewUser;
import com.Ltuc.BcryptProj.models.Posts;
import com.Ltuc.BcryptProj.repositries.NewUserReopsitry;
import com.Ltuc.BcryptProj.repositries.PostsRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostsController {

    @Autowired
    PostsRepositry postsRepositry;

    @Autowired
    NewUserReopsitry newUserReopsitry;
    @GetMapping("/")
     public String postsPage() {
         return "posts.html";
     }

     @PostMapping("/")
     public RedirectView newPost(String textContent , Long userId){
         NewUser user = newUserReopsitry.findById(userId);
//                 .orElseThrow(() -> new PostsNotFound("Could not find posts "));;
         Posts post = new Posts(textContent,user);
        return new RedirectView("/");
     }
}
