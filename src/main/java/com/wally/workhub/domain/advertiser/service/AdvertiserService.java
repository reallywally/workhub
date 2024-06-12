package com.wally.workhub.domain.advertiser.service;

import com.wally.workhub.domain.advertiser.model.Advertiser;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserResponse;
import com.wally.workhub.domain.advertiser.repository.AdvertiserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvertiserService {
    private final AdvertiserRepository advertiserRepository;

    public AdvertiserResponse findAdvertiserById(Long advertiserId) {
        Optional<Advertiser> advertiser = advertiserRepository.findById(advertiserId);
        if (advertiser.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 광고주입니다.");
        }

        return AdvertiserResponse.builder()
                .businessNumber(advertiser.get().getBusinessNumber())
                .businessName(advertiser.get().getBusinessName())
                .advertiserName(advertiser.get().getAdvertiserName())
                .build();
    }

    public void createAdvertiser(Advertiser advertiser) {
        Optional<Advertiser> findAdvertiser = advertiserRepository.findByBusinessNumber(advertiser.getBusinessNumber());
        if (findAdvertiser.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 사업자 번호입니다.");
        }

        advertiserRepository.save(advertiser);
    }
}
