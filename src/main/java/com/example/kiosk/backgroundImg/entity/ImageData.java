package com.example.kiosk.backgroundImg.entity;

import com.example.kiosk.backgroundImg.dto.ImageDataDto;
import lombok.*;

import java.util.UUID;

@Setter
@Getter @ToString
@AllArgsConstructor
public class ImageData {

    private int id; //pk

    private String name;

/*    private String type;*/


    public ImageData() {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
    }

    // dto를 entity로 변환
    public UserEntity(UserRequestDTO dto) {
        this();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
    }


}
