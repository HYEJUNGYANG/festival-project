package com.festival.festival.repository.custom;

import com.festival.festival.entity.QReview;
import com.festival.festival.entity.Review;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    private QReview review = QReview.review; // 기본 인스턴스 사용

    public ReviewRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<Review> getList(Long idx) {
        List<Review> dto = queryFactory
                .select(review)
                .from(review)
                .where(review.e_idx.eq(idx))
                .fetch();
        return dto;
    }
}
