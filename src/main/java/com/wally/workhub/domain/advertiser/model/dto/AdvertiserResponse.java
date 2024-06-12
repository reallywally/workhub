package com.wally.workhub.domain.advertiser.model.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvertiserResponse {
    private String businessNumber;
    private String businessName;
    private String advertiserName;
}
