package com.festival.festival.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Data
@Table(name = "exp")
public class Exp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NonNull
    @Column(length = 50)
    private String name;

    @NonNull
    @Column(length = 2)
    private String zone;//시,도

    @NonNull
    @Column(length = 20)
    private String l_name;//구

    @NonNull
    @Column(length = 1000)
    private String detail;

    @Column(length = 250, nullable = false)
    private String filename;

    @Column(length = 250, nullable = false)
    private String filepath;


    @NonNull
    @Column(length = 200)
    private String place;//장소

    @NonNull
    @Column(length = 1000)
    private String content;

    @NonNull
    @Column(length = 1000)
    private String warning;

    @NonNull
    @Column(length = 13)
    private String tel;//문의번호

    @NonNull
    @Column(length = 100)
    private String link;//홈페이지

    @NonNull
    @Column(length = 11)
    private String time;//이용시간

    @NonNull
    @Column
    private int price;

    @NonNull
    @Column(length = 100)
    private String tag;

    @NonNull
    @Column
    private double latitude;//위도

    @NonNull
    @Column
    private double hardness;//경도

}
