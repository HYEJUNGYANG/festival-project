package com.festival.festival.repository.custom;


import com.festival.festival.dto.ReserveDTO;

import java.util.List;

public interface ReserveRepositoryCustom {
    void modifyById(ReserveDTO dto);

    List<Integer> getNumList();

    void insertReserv(ReserveDTO reserveDTO);
}
