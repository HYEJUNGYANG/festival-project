package com.festival.festival.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NonNull
    @Column(length = 1000)
    private String a_content;//답변내용

    @NonNull
    @Column
    private LocalDate date;

    @NonNull
    @Column
    private Long q_idx;

}
