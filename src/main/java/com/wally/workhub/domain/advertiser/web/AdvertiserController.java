package com.wally.workhub.domain.advertiser.web;

import com.wally.workhub.domain.advertiser.model.dto.AdvertiserCreate;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserEdit;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserResponse;
import com.wally.workhub.domain.advertiser.service.AdvertiserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdvertiserController {

    private final AdvertiserService advertiserService;

    @GetMapping("/advertisers")
    public List<AdvertiserResponse> getAdvertisers(Pageable pageable) {
        return advertiserService.getList(pageable);
    }

    @GetMapping("/advertisers/{advertiserId}")
    public String getAdvertiserById(@PathVariable Long advertiserId) {
        AdvertiserResponse advertiser = advertiserService.findAdvertiserById(advertiserId);

        return "광고주 단건 조회";
    }

    @PostMapping("/advertisers")
    public String createAdvertiser(@RequestBody AdvertiserCreate advertiserCreate) {
        advertiserService.createAdvertiser(advertiserCreate);
        return "광고주 등록";
    }

    @PatchMapping("/advertisers/{advertiserId}")
    public String updateAdvertiser(@PathVariable Long advertiserId, @RequestBody AdvertiserEdit advertiserEdit) {
        return "광고주 수정";
    }

    @DeleteMapping("/advertisers/{advertiserId}")
    public String deleteAdvertiser(@PathVariable Long advertiserId) {
        return "광고주 삭제";
    }
}
