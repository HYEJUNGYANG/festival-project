package com.festival.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerDTO {

    private Long idx;
    private String a_content;
    private LocalDate date;
    private Long q_idx;

}
