package com.Ltuc.BcryptProj.controllers;

import com.Ltuc.BcryptProj.exceptions.PostsNotFound;
import com.Ltuc.BcryptProj.models.NewUser;
import com.Ltuc.BcryptProj.models.Posts;

import com.Ltuc.BcryptProj.repositries.NewUserRepositry;
import com.Ltuc.BcryptProj.repositries.PostsRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostsController {

    @Autowired
    PostsRepositry postsRepositry;

    @Autowired
    NewUserRepositry newUserRepository;




    @GetMapping("/posts")
     public String postsAdded(HttpServletRequest request, Model m){

        HttpSession session = request.getSession();
       String userName= session.getAttribute("userName").toString();

//        m.addAttribute("userName", userName);
        NewUser newUser = newUserRepository.findByUserName("userName");

        if(newUser != null){
            List<Posts> posts = newUser.getPosts();
            m.addAttribute("posts",posts);
        }



        return "posts.html";
     }



    @PostMapping("/addPost")
     public RedirectView newPost(String postContent, HttpServletRequest request, Long userId){

        HttpSession session = request.getSession();
        String userName = session.getAttribute("userName").toString();

        NewUser newUser = newUserRepository.findByUserName(userName);
        if(newUser != null) {
            Posts post = new Posts(postContent, newUser);
            postsRepositry.save(post);
        }
        return new RedirectView("/posts");

  }
}
