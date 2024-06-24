package com.wally.workhub.domain.advertiser.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "advertiser")
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Advertiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Comment("사업자 등록 번호")
    private String businessNumber;

    @Column
    @Comment("법인명")
    private String businessName;

    @Column
    @Comment("광고주명(한글)")
    private String advertiserName;

    @Column
    @Comment("광고주명(영어)")
    private String advertiserNameEng;

    @Column
    @Comment("사업장 전화번호")
    private String businessPhone;

    @Column
    @Comment("비고")
    private String note;

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
