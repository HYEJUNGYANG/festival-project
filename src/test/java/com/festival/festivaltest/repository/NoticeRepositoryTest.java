package com.festival.festivaltest.repository;

import com.festival.festival.entity.Notice;
import com.festival.festival.repository.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
class NoticeRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    public void insertNotice(){

        IntStream.rangeClosed(1,50).forEach(i ->{
            Notice notice = Notice.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .date(LocalDate.of(2023,11,11))
                    .img("img경로"+i)
                    .build();
            noticeRepository.save(notice);
        });
    }

}