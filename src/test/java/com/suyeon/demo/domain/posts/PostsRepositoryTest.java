package com.suyeon.demo.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) // SpringRunner라는 스프링 실행자를 사용해서 테스트 실행. spring-boot-test와 Junit 사이에 연결자 역할
@SpringBootTest              // 기본 @SpringBootTest 만 사용한 경우, H2 데이터베이스가 자동으로 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // junit 단위 테스트가 끝날때마다 수행
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()    // Posts에 insert/update 쿼리 실행. id 값 없으면 update, id 값 있으면 inser
                .title(title)
                .content(content)
                .author("suyeonjungdev@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
