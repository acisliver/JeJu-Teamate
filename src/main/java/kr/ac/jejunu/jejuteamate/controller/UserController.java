package kr.ac.jejunu.jejuteamate.controller;

import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.dto.StatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import kr.ac.jejunu.jejuteamate.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/sign-up")
    public StatusDto signUp(@RequestBody User user){
        User signedUpUser = userService.signUp(user);
        if(signedUpUser==null){
            System.out.println(1);
            return new StatusDto(HttpStatus.NO_CONTENT.value());
        }
        System.out.println(2);
        return new StatusDto(HttpStatus.OK.value());
    }

}
