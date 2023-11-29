package com.festival.festival.service;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.dto.PageRequestDTO;
import com.festival.festival.entity.Exp;
import com.festival.festival.dto.PageResultDTO;
import com.festival.festival.entity.Festival;

import java.util.List;

public interface ExpService {
    ExpDTO read(Long idx);
    PageResultDTO<ExpDTO, Exp> getList(PageRequestDTO requestDTO);
    List<Exp> getList(String zone);

    default Exp dtoToEntity(ExpDTO dto) {
        Exp entity = Exp.builder()
                .idx(dto.getIdx())
                .name(dto.getName())
                .zone(dto.getZone())
                .l_name(dto.getL_name())
                .detail(dto.getDetail())
                .img(dto.getImg())
                .place(dto.getPlace())
                .content(dto.getContent())
                .warning(dto.getWarning())
                .tel(dto.getTel())
                .link(dto.getLink())
                .time(dto.getTime())
                .price(dto.getPrice())
                .tag(dto.getTag())
                .latitude(dto.getLatitude())
                .hardness(dto.getHardness())
                .build();
        return entity;
    }

    //entity -> dto 변환
    default ExpDTO entityToDto(Exp entity) {
        ExpDTO dto = ExpDTO.builder()
                .idx(entity.getIdx())
                .name(entity.getName())
                .zone(entity.getZone())
                .l_name(entity.getL_name())
                .detail(entity.getDetail())
                .img(entity.getImg())
                .place(entity.getPlace())
                .content(entity.getContent())
                .warning(entity.getWarning())
                .tel(entity.getTel())
                .link(entity.getLink())
                .time(entity.getTime())
                .price(entity.getPrice())
                .tag(entity.getTag())
                .latitude(entity.getLatitude())
                .hardness(entity.getHardness())
                .build();
        return dto;
    }

    void insertExp(Exp exp);

    void deleteExp(Long idx);

    void modifyExp(ExpDTO dto);
}
