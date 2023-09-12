package com.Ltuc.BcryptProj.models;

import javax.persistence.*;

@Entity
public class Posts {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private NewUser newUser;

    private Long userId;

    private String postContent;

    public Posts() {
    }

    public Posts( String postContent, Long userId) {
        this.userId = userId;
        this.postContent = postContent;
    }

    public Posts(String postContent,NewUser newUser) {
        this.postContent=postContent;
        this.newUser=newUser;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}