package com.festival.festival.repository.custom;

import com.festival.festival.dto.NoticeDTO;
import com.festival.festival.entity.QNotice;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {
    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    private QNotice notice = QNotice.notice; // 기본 인스턴스 사용

    public NoticeRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public void modifyById(NoticeDTO dto) {
        queryFactory
                .update(notice)
                .set(notice.title, dto.getTitle())
                .set(notice.content, dto.getContent())
//                .set(notice.img, dto.getImg())
                .set(notice.filename, dto.getFilename())
                .set(notice.filepath, dto.getFilepath())
                .where(notice.idx.eq(dto.getIdx()))
                .execute();
    }
}
