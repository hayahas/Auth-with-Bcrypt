package com.Ltuc.BcryptProj.controllers;

import com.Ltuc.BcryptProj.models.NewUser;

import com.Ltuc.BcryptProj.repositries.NewUserRepositry;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class NewUserController {
    @Autowired
    NewUserRepositry newUserRepository;

    @PostMapping("/signup")
    public RedirectView signUpPage(String userName,String hashedPassword){

        NewUser newUser = new NewUser(userName,BCrypt.hashpw(hashedPassword, BCrypt.gensalt(12)));
        newUserRepository.save(newUser);

        return new RedirectView("/login");
    }


    @PostMapping("/login")
    public RedirectView loginPage(HttpServletRequest request, String userName, String hashedPassword){

        NewUser userFromDb = newUserRepository.findByUserName(userName);

        if((userFromDb == null)
                || (!BCrypt.checkpw(hashedPassword, userFromDb.getHashedPassword()))){
            HttpSession session =request.getSession();
            session.setAttribute("userName",userName);
            return new RedirectView("/login");
        }
        return new RedirectView("/posts");


    }

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "SignupPage.html";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "LoginPage.html";
    }

}
