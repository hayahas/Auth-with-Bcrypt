package com.Ltuc.BcryptProj.controllers;

import com.Ltuc.BcryptProj.models.NewUser;
import com.Ltuc.BcryptProj.repositries.NewUserReopsitry;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class NewUserController {
    @Autowired
    NewUserReopsitry newUserReopsitry;

    @PostMapping("/signup")
    public RedirectView signUpPage(String username,String hashedPassword){

        NewUser newUser = new NewUser(username,BCrypt.hashpw(hashedPassword, BCrypt.gensalt(12)));
        newUserReopsitry.save(newUser);

        return new RedirectView("/login");
    }


    @PostMapping("/login")
    public RedirectView loginPage(String username,String hashedPassword){

        NewUser userFromDb = newUserReopsitry.findByUserName(username);

        if((userFromDb == null)
                || (!BCrypt.checkpw(hashedPassword, userFromDb.getHashedPassword()))){
            return new RedirectView("/login");
        }
        return new RedirectView("/");

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
