package com.festival.festival.repository.custom;

import com.festival.festival.dto.FestivalDTO;
import com.festival.festival.entity.Festival;
import com.festival.festival.entity.QFestival;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class FestivalRepositoryCustomImpl implements FestivalRepositoryCustom{

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    private QFestival festival = QFestival.festival; // 기본 인스턴스 사용

    public FestivalRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Festival> getAllByZone(String zone) {
        List<Festival> dto = queryFactory
                .select(festival)
                .from(festival)
                .where(festival.zone.eq(zone))
                .orderBy(festival.idx.desc())
                .fetch();
        return dto;
    }

    @Override
    public void modifyById(Long id, FestivalDTO dto) {
        // 나중에 파일 이름, 경로 추가하기
        queryFactory
                .update(festival)
                .set(festival.name, dto.getName())
                .set(festival.zone, dto.getZone())
                .set(festival.detail, dto.getDetail()) // 2023.11.29 추가 (하....)
                .set(festival.l_name, dto.getL_name())
                .set(festival.place, dto.getPlace())
                .set(festival.tel, dto.getTel())
                .set(festival.link, dto.getLink())
                .set(festival.time, dto.getTime())
                .set(festival.price, dto.getPrice())
                .set(festival.start, dto.getStart())
                .set(festival.end, dto.getEnd())
                .set(festival.latitude, dto.getLatitude())
                .set(festival.hardness, dto.getHardness())
                .where(festival.idx.eq(id))
                .execute();
    }
}
