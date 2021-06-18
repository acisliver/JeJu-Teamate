package kr.ac.jejunu.jejuteamate.controller;

import kr.ac.jejunu.jejuteamate.config.security.user.PrincipalDetails;
import kr.ac.jejunu.jejuteamate.domain.Recruit;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.dto.StatusDto;
import kr.ac.jejunu.jejuteamate.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @GetMapping("/api/read-recruit")
    public Recruit readRecruit(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        User user = principalDetails.getUser();
        return recruitService.readRecruit(user);
    }

    @PostMapping("/api/write-recruit")
    public Recruit writeRecruit(@RequestBody Recruit recruit,
                                          @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User user = principalDetails.getUser();
        return recruitService.writeRecruit(recruit, user);
    }

    @PutMapping("/api/update-recruit")
    public Recruit updateRecruit(@RequestBody Recruit recruit,
                                 @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();
        return recruitService.updateRecruit(recruit, user);
    }

    @DeleteMapping("/api/delete-recruit")
    public StatusDto deleteRecruit(@AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();
        recruitService.deleteRecruit(user);
        return new StatusDto(HttpStatus.OK.value());
    }
}
