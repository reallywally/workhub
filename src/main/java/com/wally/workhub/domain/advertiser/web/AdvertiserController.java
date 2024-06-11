package com.wally.workhub.domain.advertiser.web;

import com.wally.workhub.domain.advertiser.model.dto.AdvertiserCreate;
import com.wally.workhub.domain.advertiser.model.dto.AdvertiserEdit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdvertiserController {

    @GetMapping("/advertisers")
    public String getAdvertisers() {
        return "광고주 목록 조회";
    }

    @GetMapping("/advertisers/{advertiserId}")
    public String getAdvertiserById(@PathVariable Long advertiserId) {
        return "광고주 단건 조회";
    }

    @PostMapping("/advertisers")
    public String createAdvertiser(@RequestBody AdvertiserCreate advertiserCreate) {
        return "광고주 등록";
    }

    @PatchMapping("/advertisers/{advertiserId}")
    public String updateAdvertiser(@PathVariable Long advertiserId, @RequestBody AdvertiserEdit advertiserEdit) {
        return "광고주 수정";
    }

    @PatchMapping("/advertisers/{advertiserId}")
    public String deleteAdvertiser(@PathVariable Long advertiserId) {
        return "광고주 삭제";
    }
}
