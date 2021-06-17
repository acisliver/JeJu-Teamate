package kr.ac.jejunu.jejuteamate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeamDto {
    private String name;
    private String intro;
    private String field;
}
