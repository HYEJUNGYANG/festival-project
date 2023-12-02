package com.festival.festival.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Builder
@EntityListeners(value = {AuditingEntityListener.class})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NonNull
    @Column(length = 300)
    private String title;

    @NonNull
    @Column(length = 1000)
    private String q_content;

    @NonNull
    @Column
    private LocalDate date;

    @NonNull
    @Column(length = 10)
    private String u_nick;

    @NonNull
    @Column(length = 30)
    private String u_id;

    @NonNull
    @Column(length = 1)
    private char yn;

    @NonNull
    @Column(length = 1)
    private char priv;

    // join
    @OneToOne
    @JoinColumn(name = "answer") // unique key
    private Answer answer;

}
