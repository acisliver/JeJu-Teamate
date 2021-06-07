package kr.ac.jejunu.jejuteamate.dto;

import kr.ac.jejunu.jejuteamate.domain.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserResponse {
    int status;
    User user;
}
