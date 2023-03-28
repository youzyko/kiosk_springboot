package com.example.kiosk.user.service;



import com.example.kiosk.user.entity.User;
import com.example.kiosk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
  /*  private final MenuRepository menuRepository;

    public ItemFindAllDto menuTeaServ() {
        log.info("=============only menuname_Service");
        return new ItemFindAllDto((List<MenuName>) menuRepository.menuTea());
    }
*/
  private  final UserRepository userRepository;
    private  final PasswordEncoder encoder;
  //회원 가입 기능
  public User createServ(final User userEntity) throws RuntimeException {
      if (userEntity == null || userEntity.getId() == null) {
          throw new RuntimeException("Invalid args!");
      }

      // 패스워드 인코딩
      String rawPw = userEntity.getPwd();
      userEntity.setPwd(encoder.encode(rawPw));

      boolean flag = userRepository.register(userEntity);

      return flag
              ? getByCredential(userEntity.getId())
              : null;
  }

    private User getByCredential(String id) {
        return  userRepository.findUserById(id);
    }


}//class_end
