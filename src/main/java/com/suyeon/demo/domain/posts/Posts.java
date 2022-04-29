package com.suyeon.demo.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
// Entity 클래스에서는 setter를 절대 만들지 말자. entity에서는 값 변경을 하지 않는다. 필요하다면 값 변경 메소드를 따로 작성하자.
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    // @Column 은 굳이 선언하지 않더라도 @Entity 클래스 하위의 모든 필드는 컬럼이 됨. 기본값 이외에 추가로 변경이 필요한 옵션이 있으면 명시적으로 선언.

    @Builder
    public Posts(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
