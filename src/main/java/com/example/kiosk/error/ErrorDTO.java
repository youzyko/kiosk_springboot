package com.example.kiosk.error;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private  String message; //에러메시지
}
