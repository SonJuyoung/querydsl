package com.example.dsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardEntity> aaa(String title, int id, String ctnt) {
        return queryFactory.selectFrom(QBoardEntity.boardEntity)
                .where(QBoardEntity.boardEntity.title.contains(title)
                        .or(QBoardEntity.boardEntity.id.eq(id))
                                .or(isCtnt(ctnt))
                        )
                .fetch();
    }

    private BooleanExpression isCtnt(String ctnt) {
        return StringUtils.hasText(ctnt) ? QBoardEntity.boardEntity.ctnt.contains(ctnt) : null;
    }
}
