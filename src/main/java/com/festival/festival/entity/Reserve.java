package com.festival.festival.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Data
@Table(name = "reserve")
public class Reserve {

    @Id
    @Column(name="reserve_num")
    private int num; //랜덤8자리 숫자

    @NonNull
    @Column(length = 10)
    private String u_name;//예약자명

    @NonNull
    @Column(length = 30)
    private String u_id;//예약자id

    @NonNull
    @Column(length = 13)
    private String u_tel;//번호(유저)

    @NonNull
    @Column(length = 50)
    private String e_name;//체험명

    @NonNull
    @Column
    private LocalDate date;//체험하는날짜

    @NonNull
    @CreatedDate
    @Column(name = "now_date",updatable = false)
    private LocalDateTime now_date;

    @NonNull
    @Column(length = 4)
    private String state;//예약상태

    @NonNull
    @Column(length = 8)
    private String pay;//결제수단

    @NonNull
    @Column
    private int total;//결제금액

    @NonNull
    @Column(length = 1)
    private char review;//리뷰 y or n

    @NonNull
    @Column
    private int count;//인원수

    @NonNull
    @Column
    private int e_price;//이용요금(체험)

}
