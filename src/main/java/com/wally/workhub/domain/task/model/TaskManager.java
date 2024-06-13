package com.wally.workhub.domain.task.model;

import com.wally.workhub.domain.task.model.enums.TaskManagerCharge;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "task_manager")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TaskManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Comment("업무 요청 ID")
    private Long taskId;

    @Column
    @Comment("담당 유형")
    private TaskManagerCharge chargeType;

    @Column
    @Comment("담당자 ID")
    private Long userId;

}
