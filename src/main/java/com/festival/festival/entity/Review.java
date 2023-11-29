package com.festival.festival.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NonNull
    @Column(length = 50)
    private String e_name;//체험명

    @NonNull
    @Column(length = 150)
    private String content;//리뷰내용

    @NonNull
    @Column
    private Long e_idx;//체험 idx;

    @NonNull
    @CreatedDate
    @Column
    private LocalDate date;//리뷰 작성 날짜

    @NonNull
    @Column
    private int star;//별점

    @NonNull
    @Column(length = 10)
    private String u_nick;

    @NonNull
    @Column(length = 30)
    private String u_id; // 유저 아이디!! 가져올 값이 필요함
}
