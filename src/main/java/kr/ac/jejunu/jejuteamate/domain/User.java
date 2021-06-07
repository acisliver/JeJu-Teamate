package kr.ac.jejunu.jejuteamate.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String userName;

    @Column(nullable = false, length = 100)
    private String password;

    //상수 사용
    @Enumerated(EnumType.STRING)
    private String role;

    @CreationTimestamp
    private Timestamp createDate;
}
