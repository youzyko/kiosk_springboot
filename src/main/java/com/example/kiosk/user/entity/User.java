package com.example.kiosk.user.entity;

import com.example.kiosk.user.dto.UserRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String id; //아이디
    private String pwd; //비밀번호

    public User() {
        this.id= UUID.randomUUID().toString(); //중복 방지
    }

    public  User(UserRequest dto){
        this();
        this.id=dto.getId();
        this.pwd=dto.getPwd();
    }

    public User(User user) {
        this.id=user.getId();
        this.pwd=user.getPwd();
    }
}//class_end
