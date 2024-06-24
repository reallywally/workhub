package com.wally.workhub.domain.advertiser.service;

import com.wally.workhub.common.PagingResponse;
import com.wally.workhub.domain.advertiser.entity.Advertiser;
import com.wally.workhub.domain.advertiser.model.AdvertiserCreate;
import com.wally.workhub.domain.advertiser.model.AdvertiserEdit;
import com.wally.workhub.domain.advertiser.model.AdvertiserResponse;
import com.wally.workhub.domain.advertiser.model.AdvertiserSearch;
import com.wally.workhub.domain.advertiser.repository.AdvertiserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvertiserService {
    private final AdvertiserRepository advertiserRepository;

    public PagingResponse<AdvertiserResponse> getList(AdvertiserSearch advertiserSearch) {
        Page<Advertiser> list = advertiserRepository.getList(advertiserSearch);

        return new PagingResponse<>(list, AdvertiserResponse.class);
    }

    public AdvertiserResponse findAdvertiserById(Long advertiserId) {
        Optional<Advertiser> advertiser = advertiserRepository.findById(advertiserId);
        if (advertiser.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 광고주입니다.");
        }

        return new AdvertiserResponse(advertiser.get());
    }

    public void createAdvertiser(AdvertiserCreate advertiserCreate) {
        Optional<Advertiser> findAdvertiser = advertiserRepository.findByBusinessNumber(advertiserCreate.getBusinessNumber());
        if (findAdvertiser.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 사업자 번호입니다.");
        }

        Advertiser advertiser = Advertiser.builder()
                .businessNumber(advertiserCreate.getBusinessNumber())
                .businessName(advertiserCreate.getBusinessName())
                .advertiserName(advertiserCreate.getAdvertiserName())
                .build();

        advertiserRepository.save(advertiser);
    }

    public void updateAdvertiser(Long advertiserId, AdvertiserEdit advertiserEdit) {

    }

    public void deleteAdvertiser(Long advertiserId) {
        Optional<Advertiser> advertiser = advertiserRepository.findById(advertiserId);
        if (advertiser.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 광고주입니다.");
        }

        advertiserRepository.delete(advertiser.get());
    }
}
