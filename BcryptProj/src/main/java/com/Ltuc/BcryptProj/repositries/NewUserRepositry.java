package com.Ltuc.BcryptProj.repositries;

import com.Ltuc.BcryptProj.models.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewUserRepositry extends JpaRepository<NewUser,Long> {
    NewUser findByUserName(String userName);

}
