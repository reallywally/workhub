package com.wally.workhub.domain.advertiser.model;


import com.wally.workhub.domain.advertiser.entity.Advertiser;
import lombok.Builder;
import lombok.Data;

@Data
public class AdvertiserResponse {
    private Long id;
    private String businessNumber;
    private String businessName;
    private String advertiserName;

    public AdvertiserResponse(Advertiser advertiser) {
        this.id = advertiser.getId();
        this.businessNumber = advertiser.getBusinessNumber();
        this.businessName = advertiser.getBusinessName();
        this.advertiserName = advertiser.getAdvertiserName();
    }
}
