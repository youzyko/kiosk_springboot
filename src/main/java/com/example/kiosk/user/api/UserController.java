package com.example.kiosk.user.api;



import com.example.kiosk.error.ErrorDTO;
import com.example.kiosk.security.TokenProvider;
import com.example.kiosk.user.dto.UserRequest;
import com.example.kiosk.user.dto.UserResponse;
import com.example.kiosk.user.entity.User;
import com.example.kiosk.user.service.UserService;
import com.example.kiosk.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin

public class UserController {
    private final UserService userService;
    private final TokenProvider tokenProvider;
    @Value("${upload.path}")
    private String uploadRootPath;
     //회원가입
     @PostMapping("/signup")
     public ResponseEntity<?> register(
             @RequestPart("userInfo") User user)
             throws IOException{
         try {
             User user1 = userService.createServ(user);
             return  ResponseEntity.ok().body(new UserResponse(user1));
         }
         catch (RuntimeException e){
             return ResponseEntity.badRequest().body(e.getMessage());

         }
     }
    //로그인
   @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRequest dto) {
        log.info("/auth/signin POST!! - login info : {}", dto);

        try {
            User user
                    = userService.validateLogin(dto.getId(), dto.getPwd());

            // 토큰 생성
            final String token = tokenProvider.create(user);
                log.info("==========token:{}",token);
            UserResponse responseDTO = new UserResponse(user);
            responseDTO.setToken(token); // 발행한 토큰을 응답정보에 포함

            return ResponseEntity.ok().body(responseDTO);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
        }
    } //signin_end



}//class end
