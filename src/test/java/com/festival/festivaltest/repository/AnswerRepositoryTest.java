package com.festival.festivaltest.repository;

import com.festival.festival.entity.Answer;
import com.festival.festival.repository.AnswerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
class AnswerRepositoryTest {
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    public void insertAnswer(){

        IntStream.rangeClosed(1,50).forEach(i ->{
            Answer answer = Answer.builder()
                    .a_content("답변내용 "+i)
                    .date(LocalDate.of(2000,11,11))
                    .q_idx((long) i)
                    .build();
            answerRepository.save(answer);
        });
    }
}