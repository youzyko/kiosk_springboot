package com.example.kiosk.user.repository;

import com.example.kiosk.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    User findUserById(String id);

    boolean register(User user);

}
