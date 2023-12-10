package com.festival.festival.repository.custom;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.entity.Exp;

import java.util.HashMap;
import java.util.List;

public interface ExpRepositoryCustom {
    void modifyById(ExpDTO dto);

    List<Exp> getAllByZone(String zone);

    List<Exp> getExpListByKeyword(HashMap<String, Object> map);

    void modifyCount(Long count, Long idx);

    List<Exp> findTop3ByOrderByIdDesc();// idx를 기준, desc로 3개의 데이터를 꺼내옴

    List<Exp> getListByIdxs(int[] idxList);
}
