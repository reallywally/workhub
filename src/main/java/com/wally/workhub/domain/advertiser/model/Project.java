package com.wally.workhub.domain.advertiser.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "project")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Comment("광고주 ID")
    private Long advertiserId;

    @Column
    @Comment("프로젝트명")
    private String projectName;

    @Column
    @Comment("프로젝트 설명")
    private String projectDescription;

    @Column
    @Comment("상태")
    private String status;

    @Column
    @Comment("등록일")
    private String createdAt;

    @Column
    @Comment("수정일")
    private String updatedAt;

}
