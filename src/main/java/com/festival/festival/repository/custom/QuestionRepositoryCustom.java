package com.festival.festival.repository.custom;

import com.festival.festival.dto.QuestionDTO;

public interface QuestionRepositoryCustom {
    void InsertQuestion(QuestionDTO dto);

    void updateQuestion(QuestionDTO dto);
}
