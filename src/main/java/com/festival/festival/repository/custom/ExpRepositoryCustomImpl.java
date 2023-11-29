package com.festival.festival.repository.custom;

import com.festival.festival.dto.ExpDTO;
import com.festival.festival.entity.QExp;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ExpRepositoryCustomImpl implements ExpRepositoryCustom {
    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    private QExp exp = QExp.exp; // 기본 인스턴스 사용

    public ExpRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public void modifyById(ExpDTO dto) {
        queryFactory
                .update(exp)
                .set(exp.name, dto.getName())
                .set(exp.zone, dto.getZone())
                .set(exp.l_name, dto.getL_name())
                .set(exp.detail, dto.getDetail())
//                .set(exp.img, dto.getImg())
                .set(exp.place, dto.getPlace())
                .set(exp.tel, dto.getTel())
                .set(exp.link, dto.getLink())
                .set(exp.time, dto.getTime())
                .set(exp.price, dto.getPrice())
                .set(exp.content, dto.getContent())
                .set(exp.warning, dto.getWarning())
                .set(exp.tag, dto.getTag())
                .set(exp.latitude, dto.getLatitude())
                .set(exp.hardness, dto.getHardness())
                .where(exp.idx.eq(dto.getIdx()))
                .execute();
    }
}
