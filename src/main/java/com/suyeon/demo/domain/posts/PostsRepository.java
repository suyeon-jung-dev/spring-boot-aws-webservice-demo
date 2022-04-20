package com.suyeon.demo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DB Layer 접근자
 * mybatis 에서는 mapper, DAO 라고 부름.
 * JPA 에서는 Repository 라고 부름.
 * interface 로 생성해서, JpaRepository<Entity 클래스, PK 타입> 을 상속하면 기본 CRUD 메소드가 자동으로 생성됨.
 *
 * 그리고, Entity 클래스와 Entity Repository 클래스는 같은 패키지에서 관리해야 한다.
 * 나중에 기능단위로 프로젝트 분리할 것을 고려해서 패키지에서 관리.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
