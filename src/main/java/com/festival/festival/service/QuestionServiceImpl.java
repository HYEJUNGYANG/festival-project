package com.festival.festival.service;

import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.dto.QuestionDTO;
import com.festival.festival.entity.Question;
import com.festival.festival.repository.AnswerRepository;
import com.festival.festival.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    @Override
    public QuestionDTO read(Long idx) {
        Optional<Question> result = questionRepository.findById(idx);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public Long insertAnswer(QuestionDTO dto) {
        Question entity = dtoToEntity(dto);

        questionRepository.save(entity);

        return entity.getIdx();
    }

    @Override
    public void insertQuestion(QuestionDTO dto) {
        questionRepository.InsertQuestion(dto);
    }

    @Override
    public void updateQuestion(QuestionDTO dto) {
        questionRepository.updateQuestion(dto);
    }

    @Override
    public PageResultDTO<QuestionDTO, Question> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("idx").descending());
        Page<Question> result = questionRepository.findAll( pageable);
        Function<Question, QuestionDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn );
    }
}
