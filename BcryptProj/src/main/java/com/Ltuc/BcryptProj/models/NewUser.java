package com.Ltuc.BcryptProj.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class NewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String hashedPassword;


    @OneToMany(mappedBy = "newUser", cascade =  CascadeType.ALL)
    List<Posts> posts;
    public NewUser() {
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public NewUser(String userName , String hashedPassword){
        this.userName=userName;
        this.hashedPassword=hashedPassword;

    }
    public NewUser(String userName , String hashedPassword, List<Posts> posts){
        this.userName=userName;
        this.hashedPassword=hashedPassword;
        this.posts=posts;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setHashedPassword(String hashedPassword){
        this.hashedPassword=hashedPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
