package com.example.kiosk.user.dto;



import com.example.kiosk.user.entity.User;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String pwd;
    private String token; //인증토큰

    public UserResponse(User user){
        this.id=user.getId();
        this.pwd=user.getPwd();
    }

} //class_end
