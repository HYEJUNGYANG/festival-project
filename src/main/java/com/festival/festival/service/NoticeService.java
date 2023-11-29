package com.festival.festival.service;

import com.festival.festival.dto.NoticeDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Notice;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
    NoticeDTO read(Long idx);

    PageResultDTO<NoticeDTO, Notice> getList(PageRequestDTO requestDTO);

    default Notice dtoToEntity(NoticeDTO dto) {
        Notice entity = Notice.builder()
                .idx(dto.getIdx())
                .title(dto.getTitle())
                .content(dto.getContent())
                .date(dto.getDate())
                .build();
        return entity;
    }

    //entity -> dto 변환
    default NoticeDTO entityToDto(Notice entity) {
        NoticeDTO dto = NoticeDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .date(entity.getDate())
                .build();
        return dto;
    }

    void insertNotice(Notice notice);

    void deleteNotice(Long idx);

    void modifyNotice(NoticeDTO dto);

}
