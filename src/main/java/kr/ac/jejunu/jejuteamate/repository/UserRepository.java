package kr.ac.jejunu.jejuteamate.repository;

import kr.ac.jejunu.jejuteamate.config.security.user.AuthUser;
import kr.ac.jejunu.jejuteamate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM User WHERE emiail= ?1", nativeQuery = true)
    User searchUserQuery(String email);

    @Query(value = "SELECT * FROM User WHERE id= ?1", nativeQuery = true)
    Optional<User> searchIdQuery(int id);
}
