package com.suyeon.demo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseTimeEntity 클래스는 모든 Entity 의 상위 클래스로,
 * 모든 Entity 들의 createdDate, modifiedDate 를 관리
 */
@Getter
@MappedSuperclass   // JPA Entity 클래스가 BaseTimeEntity 를 상속할 경우 필드도 같이 컬럼으로 인식하도록 하는 annotation
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity 클래스에 Auditing 기능 추가
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
