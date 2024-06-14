package com.wally.workhub.domain.task.domain;

import com.wally.workhub.enums.TaskProgressStage;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "task")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Comment("광고주 ID")
    private Long advertiserId;

    @Column
    @Comment("프로젝트 ID")
    private Long projectId;

    @Column
    @Comment("플랫폼")
    private String platform;

    @Column
    @Comment("플랫폼 상품")
    private String platformProduct;

    @Column
    @Comment("요청명")
    private String requestName;

    @Column
    @Comment("요청 내용")
    private String content;

    @Column
    @Comment("진행 단계")
    private TaskProgressStage progressStage;

    @Column
    @Comment("상태")
    private String status;

    @Column
    @Comment("마감일")
    private LocalDateTime deadline;

    @Column
    @Comment("등록일")
    private String createdAt;

    @Column
    @Comment("수정일")
    private String updatedAt;
}
