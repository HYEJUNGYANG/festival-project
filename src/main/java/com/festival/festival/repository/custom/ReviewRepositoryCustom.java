package com.festival.festival.repository.custom;

import com.festival.festival.entity.Review;
import com.querydsl.core.Tuple;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> getList(Long idx);
}
