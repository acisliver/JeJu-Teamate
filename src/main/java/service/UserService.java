package service;

import kr.ac.jejunu.jejuteamate.domain.RoleType;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User signUp(User user){
        userRepository.save(user);
        return user;
    }


}
