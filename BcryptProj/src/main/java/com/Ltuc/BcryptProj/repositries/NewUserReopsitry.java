package com.Ltuc.BcryptProj.repositries;

import com.Ltuc.BcryptProj.models.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewUserReopsitry extends JpaRepository<NewUser,Long> {
    NewUser findByUserName(String userName);

    void save(NewUser newUser);


    NewUser findById(Long userId);
}
