package com.wally.workhub.domain.advertiser.model.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AdvertiserCreate {
    private String businessNumber;
    private String businessName;
    private String advertiserName;
}
