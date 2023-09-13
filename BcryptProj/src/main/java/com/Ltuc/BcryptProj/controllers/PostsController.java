package com.Ltuc.BcryptProj.controllers;

import com.Ltuc.BcryptProj.exceptions.PostsNotFound;
import com.Ltuc.BcryptProj.models.NewUser;
import com.Ltuc.BcryptProj.models.Posts;

import com.Ltuc.BcryptProj.repositries.NewUserRepositry;
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
    NewUserRepositry newUserRepository;
    @GetMapping("/posts")
     public String postsPage() {
         return "posts.html";
     }


     @PostMapping("/posts")
  public RedirectView newPost(String postContent, Long userId){

        NewUser newUser =  newUserRepository.findById(userId)
                .orElseThrow(() -> new PostsNotFound("user not registered"));

        Posts post=new Posts(postContent,newUser);
        postsRepositry.save(post);
        return new RedirectView("/posts");

  }
}
