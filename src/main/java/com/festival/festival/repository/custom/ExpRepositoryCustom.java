package com.festival.festival.repository.custom;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.entity.Exp;

import java.util.List;

public interface ExpRepositoryCustom {
    void modifyById(ExpDTO dto);

    List<Exp> getAllByZone(String zone);

    void modifyCount(Long count, Long idx);
}
