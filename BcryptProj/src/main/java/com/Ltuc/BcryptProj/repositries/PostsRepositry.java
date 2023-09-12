package com.Ltuc.BcryptProj.repositries;

import com.Ltuc.BcryptProj.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepositry extends JpaRepository<Posts,Long> {
}
