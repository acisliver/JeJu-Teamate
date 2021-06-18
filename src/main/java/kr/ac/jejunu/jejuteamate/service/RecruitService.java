package kr.ac.jejunu.jejuteamate.service;

import kr.ac.jejunu.jejuteamate.domain.Recruit;
import kr.ac.jejunu.jejuteamate.domain.User;
import kr.ac.jejunu.jejuteamate.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RecruitService {

    @Autowired
    RecruitRepository recruitRepository;

    @Transactional
    public Recruit readRecruit(User user){
        return user.getRecruit();
    }

    @Transactional
    public Recruit writeRecruit(Recruit recruit, User user){
        recruit.setUser(user);
        return recruitRepository.save(recruit);
    }

    @Transactional
    public Recruit updateRecruit(Recruit recruit, User user) {
        Recruit rawRecruit = user.getRecruit();
        rawRecruit.setContent(recruit.getContent());
        recruitRepository.save(rawRecruit);
        return rawRecruit;
    }

    @Transactional
    public void deleteRecruit(User user) {
        recruitRepository.delete(user.getRecruit());
    }
}
