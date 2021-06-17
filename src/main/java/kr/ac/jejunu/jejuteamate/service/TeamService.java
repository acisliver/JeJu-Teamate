package kr.ac.jejunu.jejuteamate.service;

import kr.ac.jejunu.jejuteamate.domain.Team;
import kr.ac.jejunu.jejuteamate.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Team registerTeam(Team team) {
        teamRepository.save(team);
        return team;
    }
}
