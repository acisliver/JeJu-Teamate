package kr.ac.jejunu.jejuteamate.repository;

import kr.ac.jejunu.jejuteamate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
