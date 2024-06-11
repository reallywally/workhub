package com.wally.workhub.domain.advertiser.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "advertiser")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @Comment("대표자명")
    private String ceoName;

    @Column
    @Comment("업태")
    private String businessType;

    @Column
    @Comment("종목")
    private String businessCategory;

    @Column
    @Comment("사업장 주소")
    private String businessAddress;

    @Column
    @Comment("사업장 전화번호")
    private String businessPhone;

    @Column
    @Comment("계좌 은행")
    private String bank;

    @Column
    @Comment("계좌 번호")
    private String accountNumber;

    @Column
    @Comment("계좌 예금주")
    private String accountHolder;

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
