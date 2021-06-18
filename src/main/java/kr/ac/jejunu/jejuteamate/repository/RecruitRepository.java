package kr.ac.jejunu.jejuteamate.repository;

import kr.ac.jejunu.jejuteamate.domain.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
    @Query(value = "SELECT * FROM recruit WHERE USER_ID= ?1", nativeQuery = true)
    Recruit findByUserId(long id);
}
