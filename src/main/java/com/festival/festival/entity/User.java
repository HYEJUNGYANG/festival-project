package com.festival.festival.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {
    //id, pw, name, nick, gender, tel, birth, join_date
    //id varchar(30), pw varchar(20), name varchar(10)
    //gender char(1), tel vc(13), birth date, join_date date

    @Id
    @Column(length = 30)
    private String id;

    @Column(length = 60, nullable = false)
    private String pw;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String nick;

    @Column(length = 1, nullable = false)
    private char gender;

    @Column(length = 13, nullable = false)
    private String tel;

    @Column(length = 500, nullable = false)
    private String f_list;

    @Column(length = 500, nullable = false)
    private String e_list;

    @Enumerated(EnumType.STRING)
    @Setter
    private Role role;

    @Column(length = 20, nullable = false)
    private LocalDate birth;


    @CreatedDate
    @Column(name ="join_date", updatable = false, nullable = false)
    private LocalDateTime join_date;

    @Builder(builderClassName = "UserDetailRegister", builderMethodName = "userDetailRegister")
    public User(String id, String pw, String name, String nick, char gender, String tel, String f_list, String e_list, Role role, LocalDate birth, LocalDateTime join_date ) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.nick = nick;
        this.gender = gender;
        this.f_list = f_list;
        this.e_list = e_list;
        this.tel = tel;
        this.role = role;
        this.birth = birth;
        this.join_date = join_date;
    }

}
