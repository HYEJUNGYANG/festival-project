package com.festival.festival.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = 1124816836L;

    public static final QQuestion question = new QQuestion("question");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final ComparablePath<Character> priv = createComparable("priv", Character.class);

    public final StringPath q_content = createString("q_content");

    public final StringPath title = createString("title");

    public final StringPath u_id = createString("u_id");

    public final StringPath u_nick = createString("u_nick");

    public final ComparablePath<Character> yn = createComparable("yn", Character.class);

    public QQuestion(String variable) {
        super(Question.class, forVariable(variable));
    }

    public QQuestion(Path<? extends Question> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestion(PathMetadata metadata) {
        super(Question.class, metadata);
    }

}

