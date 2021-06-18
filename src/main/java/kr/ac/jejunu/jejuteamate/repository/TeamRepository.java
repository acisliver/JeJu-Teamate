package kr.ac.jejunu.jejuteamate.repository;

import kr.ac.jejunu.jejuteamate.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "select * from team where name=?1", nativeQuery = true)
    Team findByName(String teamName);
}
