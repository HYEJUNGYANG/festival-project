package com.festival.festival.service;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Exp;
import com.festival.festival.repository.ExpRepository;
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
public class ExpServiceImpl implements ExpService {

        private final ExpRepository expRepository;

        public PageResultDTO<ExpDTO, Exp> getList(PageRequestDTO requestDTO){
            Pageable pageable = requestDTO.getPageable(Sort.by("idx").descending());
            Page<Exp> result = expRepository.findAll((pageable));
            Function<Exp, ExpDTO> fn = (entity -> entityToDto(entity));
            return new PageResultDTO<>(result, fn);

        }

        @Override
        public ExpDTO read(Long idx) {
            Optional<Exp> result = expRepository.findById(idx);

            return result.isPresent()? entityToDto(result.get()): null;
        }

        @Override
        public void insertExp(Exp exp) {

            expRepository.save(exp);
        }

        @Override
        public void deleteExp(Long idx) {

            expRepository.deleteById(idx);
        }

        @Override
        public void modifyExp(ExpDTO dto){
            expRepository.modifyById(dto);
        }




}
