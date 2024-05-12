package com.est.neonaduri.domain.posts.repository;

import com.est.neonaduri.domain.posts.domain.Posts;
import com.est.neonaduri.domain.posts.dto.PostSearchCondition;
import com.est.neonaduri.domain.posts.repository.PostsCustomRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.est.neonaduri.domain.posts.domain.QPosts.posts;

public class PostsRepositoryImpl implements PostsCustomRepository {
    private final JPAQueryFactory queryFactory;

    public PostsRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<Posts> search(PostSearchCondition content) {
        return queryFactory
                .selectFrom(posts)
                .where(titleLike(content.getSearchText())
                        .or(writerEq(content.getSearchText()))
                        .or(categoryEq(content.getSearchText())))
                .orderBy(posts.created.desc())
                .fetch();
    }

    //조건 1 게시물 제목이 포함된 입력
    private BooleanExpression titleLike(String title){
        // 입력받은 title에 공백 제거 후 비교
        if(StringUtils.hasText(title)){
            String titleWithoutSpaces = title.replace(" ", "");
            return Expressions.stringTemplate("function('replace',{0},{1},{2})", posts.postTitle, " ", "").contains(titleWithoutSpaces);
        }else {
            return null;
        }
    }
    // 조건 2  게시물 카테고리명(전체) 포합된 입력
    private BooleanExpression categoryEq(String category){
        return StringUtils.hasText(category) ?posts.postCategory.eq(category) : null;
    }

    //조건 3 게시물 작성자 이름(전체) 포함된 입력
    private BooleanExpression writerEq(String writer){
        return StringUtils.hasText(writer) ?posts.users.userName.eq(writer) : null;
    }
}
