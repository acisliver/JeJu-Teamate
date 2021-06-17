package kr.ac.jejunu.jejuteamate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private long id;

    //팀명
    @Column(nullable = false, length = 100, unique = true)
    private String name;

    //팀 소개
    @Column
    private String intro;

    //웹, 안드로이드 등 분야
    @Column
    private String field;

    //팀원
    @OneToMany(mappedBy = "team")
    List<User> teammate;

    @CreationTimestamp
    private Timestamp createDate;
}
