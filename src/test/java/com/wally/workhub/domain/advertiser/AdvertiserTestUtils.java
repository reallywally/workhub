package com.wally.workhub.domain.advertiser;

import com.wally.workhub.domain.advertiser.model.Advertiser;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserCreate;

public class AdvertiserTestUtils {
    public static Advertiser generateAdvertiser() {
        return Advertiser.builder()
                .businessNumber("123-45-67890")
                .businessName("테스트 광고주")
                .build();
    }
    public static AdvertiserCreate generateAdvertiserCreate() {
        return AdvertiserCreate.builder()
                .businessNumber("123-45-67890")
                .businessName("테스트 광고주")
                .advertiserName("테스트 광고주")
                .build();
    }
}
