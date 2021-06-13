package kr.ac.jejunu.jejuteamate.config.security;

import kr.ac.jejunu.jejuteamate.config.security.user.PrincipalDetails;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.printf("loadUserByUsername");
        User user = userRepository.searchUserQuery(username);
        System.out.printf("user: " + user.toString());
        System.out.printf("user서비스에서의 비밀번호: "+ user.getPassword());
        return new PrincipalDetails(user);
    }
}
