package kr.ac.jejunu.jejuteamate.controller;

import kr.ac.jejunu.jejuteamate.config.security.user.PrincipalDetails;
import kr.ac.jejunu.jejuteamate.domain.Team;
import kr.ac.jejunu.jejuteamate.dto.StatusDto;
import kr.ac.jejunu.jejuteamate.dto.TeamDto;
import kr.ac.jejunu.jejuteamate.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/api/find-team")
    public List<Team> listTeams() {
        return teamService.listTeams();
    }

    @PostMapping("/api/register-team")
    public StatusDto registerTeam(@RequestBody TeamDto teamDto,
                                  @AuthenticationPrincipal PrincipalDetails principalDetails) {

        Team team = new Team();
        team.setName(teamDto.getName());
        team.setIntro(teamDto.getIntro());
        team.setField(teamDto.getField());

        System.out.println(teamDto);

        Team registeredTeam = teamService.registerTeam(team, principalDetails.getUser());

        //팀 생성 실패
        if (registeredTeam == null){
            return new StatusDto(HttpStatus.NO_CONTENT.value());
        }
        //팀 생성 성공
        return new StatusDto(HttpStatus.OK.value());
    }
}
