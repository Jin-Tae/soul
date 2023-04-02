package com.soulbrain.cicd.soulbrain.board.entity;


import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreationTimestamp //생성될 경우
    @Column(updatable = false)  //updatable 할떄는 관여를 안하곘다.
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(insertable = false) //insert 할떄는 관여를 안하곘다.
    private LocalDateTime updatedTime;
}
