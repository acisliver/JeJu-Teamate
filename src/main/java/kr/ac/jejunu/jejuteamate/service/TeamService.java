package kr.ac.jejunu.jejuteamate.service;

import kr.ac.jejunu.jejuteamate.domain.Team;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.TeamRepository;
import kr.ac.jejunu.jejuteamate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Transactional
    public List<Team> listTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }

    @Transactional
    public Team registerTeam(Team team, User user) {
        team.setLeader(user);
        teamRepository.save(team);
        return team;
    }
}
