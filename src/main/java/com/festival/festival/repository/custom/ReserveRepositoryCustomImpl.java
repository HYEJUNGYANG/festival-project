package com.festival.festival.repository.custom;

import com.festival.festival.dto.ReserveDTO;
import com.festival.festival.entity.QReserve;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ReserveRepositoryCustomImpl implements ReserveRepositoryCustom{
    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    private QReserve reserve = QReserve.reserve; // 기본 인스턴스 사용

    public ReserveRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public void modifyById(ReserveDTO dto) {
        queryFactory
                .update(reserve)
                .set(reserve.state, dto.getState())
                .where(reserve.num.eq(dto.getNum()))
                .execute();
    }
}
