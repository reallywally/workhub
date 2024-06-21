package com.wally.workhub.domain.advertiser.service;

import com.wally.workhub.domain.advertiser.AdvertiserTestUtils;
import com.wally.workhub.domain.advertiser.model.Advertiser;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserCreate;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserResponse;
import com.wally.workhub.domain.advertiser.repository.AdvertiserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class AdvertiserServiceTest {

    @Mock
    private AdvertiserRepository advertiserRepository;

    @InjectMocks
    private AdvertiserService advertiserService;

    @Test
    void findAdvertiserById() {
        Advertiser advertiser = AdvertiserTestUtils.generateAdvertiser();
        given(advertiserRepository.findById(any(Long.class))).willReturn(Optional.of(advertiser));

        AdvertiserResponse advertiserResponse = advertiserService.findAdvertiserById(1L);

        Assertions.assertEquals(advertiser.getBusinessNumber(), advertiserResponse.getBusinessNumber());
    }

    @Test
    void createAdvertiserFail() {
        Advertiser advertiser = AdvertiserTestUtils.generateAdvertiser();
        AdvertiserCreate advertiserCreate = AdvertiserTestUtils.generateAdvertiserCreate();
        given(advertiserRepository.findByBusinessNumber(any(String.class))).willReturn(Optional.of(advertiser));

        try {
            advertiserService.createAdvertiser(advertiserCreate);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("이미 존재하는 사업자 번호입니다.", e.getMessage());
        }
    }
}