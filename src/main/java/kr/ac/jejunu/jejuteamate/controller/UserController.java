package kr.ac.jejunu.jejuteamate.controller;

import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.dto.StatusDto;
import kr.ac.jejunu.jejuteamate.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import kr.ac.jejunu.jejuteamate.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/get")
    public String get(){
        return "get";
    }

    //회원가입
    @PostMapping("/api/sign-up")
    public StatusDto signUp(@RequestBody UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setNickName(userDto.getNickName());
        user.setJob(userDto.getJob());

        System.out.println(userDto);

        User signedUpUser = userService.signUp(user);
        if(signedUpUser==null){
            return new StatusDto(HttpStatus.NO_CONTENT.value());
        }
        return new StatusDto(HttpStatus.OK.value());
    }

}
