package kr.ac.jejunu.jejuteamate.repository;

import kr.ac.jejunu.jejuteamate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String username);
}
