package kr.ac.jejunu.jejuteamate.service;

import kr.ac.jejunu.jejuteamate.domain.RoleType;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User signUp(User user){
        user.setPassword(encoder.encode(user.getPassword())); //비밀번호 인코딩
        user.setRole(RoleType.USER);  //최초 가입시 권한 설정
        userRepository.save(user);
        return user;
    }

//    @Transactional
//    public String login(User user){
//        User member = userRepository.findByEmail(user.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 email입니다"));
//        if(!)
//    }
}
