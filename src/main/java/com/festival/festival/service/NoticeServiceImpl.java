package com.festival.festival.service;

import com.festival.festival.dto.NoticeDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Notice;
import com.festival.festival.repository.NoticeRepository;
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
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private final NoticeRepository noticeRepository;

    @Override
    public NoticeDTO read(Long idx) {
        Optional<Notice> result = noticeRepository.findById(idx);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public PageResultDTO<NoticeDTO, Notice> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("idx").descending());
        Page<Notice> result = noticeRepository.findAll( pageable);
        Function<Notice, NoticeDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn );
    }

    @Override
    public void insertNotice(Notice notice)
        {

            noticeRepository.save(notice);
    }

    @Override
    public void deleteNotice(Long idx){

        noticeRepository.deleteById(idx);
    }


    public void modifyNotice(NoticeDTO dto){
        noticeRepository.modifyById(dto);
    }

}
