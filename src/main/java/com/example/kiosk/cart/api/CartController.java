package com.example.kiosk.cart.api;

import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.cart.service.CartService;
import com.example.kiosk.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@CrossOrigin
public class CartController {
    private  final CartService cartService;
    @Value("${upload.path}")
    private String uploadRootPath;

    @PostMapping("/incart") //장바구니에 담기 //같은이름 오류처리
    public ResponseEntity<?> addcart(@RequestBody Cart cart  ){ //JSON으로 보낼때
        //IMG있는 경우->  @RequestPart(value = "mainImg", required = true)
        log.info("ADDCART_CONTROLLER");
        log.info("{}",cart);
        /*if(cartService.existsByName(cart.getItemName())){ //같은 메뉴가 있을 경우
            return  ResponseEntity.badRequest().body(cart);
        }*/
        boolean f=cartService.add(cart);
        return  ResponseEntity.ok().body(f);
    }

    @GetMapping //전체목록 다 가져오기
    public  ResponseEntity<?> showAll(){
        log.info("SHOWALL_CONTROLLER");
        return  ResponseEntity.ok().body(cartService.showAll());

    }

    @GetMapping(value = {"/{random}"}) //해당되는 ownImgId 그림 빼오기
    public ResponseEntity<?> ImgAll(@PathVariable int random) throws IOException {
        log.info("GETIMG_CONTROLLER");
        String itemPath = cartService.getProfilePath(random);
        log.info("itemIMG=={}",itemPath);
        String fullPath = uploadRootPath + File.separator + itemPath;
        log.info("fullPath=={}",fullPath);

        // 해당 경로를 파일 객체로 포장
        File targetFile = new File(fullPath);
        log.info("targetFile=={}",targetFile);

        //해당 파일 존재x
        if(!targetFile.exists()) return  ResponseEntity.notFound().build();

        // 파일 데이터를 바이트배열로 포장 (blob 데이터)...대상 파일을 복사하여 Byte 배열로 반환해주는 클래스
        byte[] rawImageData = FileCopyUtils.copyToByteArray(targetFile);
      //  log.info("rawImageData=={}",rawImageData);
        // 응답 헤더 정보 추가
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(FileUploadUtil.getMediaType(itemPath));

        // 클라이언트에 순수 이미지파일 데이터 리턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(rawImageData);
    }

/*    @GetMapping(value = {"/{ownImgId}"})
  public ResponseEntity<List<byte[]>> ImgAll(@PathVariable String ownImgId) throws IOException {
      log.info("GETIMG_CONTROLLER");
      List<String> itemPaths = Collections.singletonList(cartService.getProfilePath(ownImgId));
      log.info("itemIMGs=={}", itemPaths);

      List<byte[]> rawImageDatas = new ArrayList<>();

      for (String itemPath : itemPaths) {
          String fullPath = uploadRootPath + File.separator + itemPath;
          log.info("fullPath=={}", fullPath);

          // 해당 경로를 파일 객체로 포장
          File targetFile = new File(fullPath);
          log.info("targetFile=={}", targetFile);

          // 파일 데이터를 바이트 배열로 포장 (blob 데이터)...대상 파일을 복사하여 Byte 배열로 반환해주는 클래스
          byte[] rawImageData = FileCopyUtils.copyToByteArray(targetFile);
          rawImageDatas.add(rawImageData);

          // 응답 헤더 정보 추가
          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(FileUploadUtil.getMediaType(itemPath));

          // 클라이언트에 순수 이미지 파일 데이터 리턴
          return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(rawImageDatas);
      }

      // If no image files were found, return a not found response
      return ResponseEntity.notFound().build();
  }*/

    @DeleteMapping(value = {"/{random}"})
    public ResponseEntity<?> delete(@PathVariable int random){
        log.info("DELETE_ITEMNAME_CONTROLLER");
        try {
            boolean f=cartService.delete(random);
            return  ResponseEntity.ok().body(f);
        }catch (RuntimeException e){
            return  ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/deleteall") //전체삭제
    public  ResponseEntity<?> delteAll(Cart cart){
        log.info("DELETE_ALL_CONTROLLER");
        try{
            boolean f=cartService.deleteall(cart);
            return  ResponseEntity.ok().body(f);
        }catch (RuntimeException e){
            return  ResponseEntity.notFound().build();

        }
    }


}//class_end
