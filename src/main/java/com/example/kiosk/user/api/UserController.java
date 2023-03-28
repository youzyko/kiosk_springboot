package com.example.kiosk.user.api;



import com.example.kiosk.user.dto.UserResponse;
import com.example.kiosk.user.entity.User;
import com.example.kiosk.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/login")
@RequiredArgsConstructor
@CrossOrigin

public class UserController {
    private final UserService userService;

    @PostMapping("/signup")  //회원가입
    public ResponseEntity<?> register(
            @RequestBody User user)
            throws IOException {
        try {
            User user1 = userService.createServ(user);
            return  ResponseEntity.ok().body(new UserResponse(user1));
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    } //signup_end



}//class end
