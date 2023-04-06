package com.example.kiosk.mainImage.dto;

import com.example.kiosk.mainImage.entity.MainImg;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImgAll {
    private  int count; //갯수
    private List<MainImg> mainImgs;
    public ImgAll(List<MainImg> mainImgs) {
        this.count = mainImgs.size();
        this.convertDtoList(mainImgs);
    }

    public void convertDtoList(List<MainImg> mainImgs){
        List<MainImg> list = new ArrayList<>();
        for (MainImg mainImg:mainImgs){
            list.add(new MainImg(mainImg));
        }
        this.mainImgs=list;
    }

}//class_end
