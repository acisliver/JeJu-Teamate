package kr.ac.jejunu.jejuteamate.service;

import kr.ac.jejunu.jejuteamate.domain.Team;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> listTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }

    public Team registerTeam(Team team, User user) {
        team.setLeader(user);
        teamRepository.save(team);
        return team;
    }
}
