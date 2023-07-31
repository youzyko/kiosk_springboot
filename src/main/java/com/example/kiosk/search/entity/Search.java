package com.example.kiosk.search.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Search {
    private LocalDate start;
    private LocalDate end;

}
