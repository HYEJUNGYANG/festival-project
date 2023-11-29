package com.festival.festival.service;

import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.dto.ReserveDTO;
import com.festival.festival.entity.Reserve;
import com.festival.festival.repository.ReserveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReserveServiceImpl implements ReserveService{

    @Autowired
    private final ReserveRepository reserveRepository;

    @Override
    public ReserveDTO read(int num) {
        Optional<Reserve> result = reserveRepository.findById(num);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public PageResultDTO<ReserveDTO, Reserve> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("num").descending());
        Page<Reserve> result = reserveRepository.findAll( pageable);
        Function<Reserve, ReserveDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn );
    }

    @Override
    public void modifyReserve(ReserveDTO dto){
        reserveRepository.modifyById(dto);
    }



}
