package com.wally.workhub.domain.advertiser.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvertiserCreate {

    @NotBlank(message = "사업자 등록 번호를 입력해 주새요")
    private String businessNumber;

    @NotBlank(message = "법인명을 입력해 주새요")
    private String businessName;

    @NotBlank(message = "광고주명을 입력해 주새요")
    private String advertiserName;

    private String advertiserNameEng;

    private String businessPhone;

    private String note;

    public void validate(){

    }
}
