package kr.ac.jejunu.jejuteamate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Recruit {

    @Id
    @JsonIgnore
    @Column(name = "RECRUIT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String content;
}
