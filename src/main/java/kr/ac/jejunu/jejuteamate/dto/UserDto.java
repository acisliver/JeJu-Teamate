package kr.ac.jejunu.jejuteamate.dto;

import kr.ac.jejunu.jejuteamate.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private String email;
    private String password;
    private String role;
}
