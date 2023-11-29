package com.festival.festival.service;

import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.dto.QuestionDTO;
import com.festival.festival.entity.Question;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    QuestionDTO read(Long idx);

    PageResultDTO<QuestionDTO, Question> getList(PageRequestDTO requestDTO);

/*
    default Question dtoToEntity(QuestionDTO dto) {
        Question entity = Question.builder()
                .idx(dto.getIdx())
                .title(dto.getTitle())
                .content(dto.getContent())
                .date(dto.getDate())
                .build();
        return entity;
    }

    //entity -> dto 변환
    default QuestionDTO entityToDto(Question entity) {
        QuestionDTO dto = QuestionDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .date(entity.getDate())
                .build();
        return dto;
    }
*/


}
