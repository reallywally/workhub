package com.wally.workhub.domain.advertiser.web;

import com.wally.workhub.common.PagingResponse;
import com.wally.workhub.domain.advertiser.model.AdvertiserCreate;
import com.wally.workhub.domain.advertiser.model.AdvertiserEdit;
import com.wally.workhub.domain.advertiser.model.AdvertiserResponse;
import com.wally.workhub.domain.advertiser.model.AdvertiserSearch;
import com.wally.workhub.domain.advertiser.service.AdvertiserService;
import jakarta.validation.Valid;
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
    public PagingResponse<AdvertiserResponse> getAdvertisers(@ModelAttribute AdvertiserSearch advertiserSearch) {
        return advertiserService.getList(advertiserSearch);
    }

    @GetMapping("/advertisers/{advertiserId}")
    public AdvertiserResponse getAdvertiserById(@PathVariable Long advertiserId) {

        return advertiserService.findAdvertiserById(advertiserId);
    }

    @PostMapping("/advertisers")
    public void createAdvertiser(@RequestBody @Valid AdvertiserCreate advertiserCreate) {
        advertiserService.createAdvertiser(advertiserCreate);
    }

    @PatchMapping("/advertisers/{advertiserId}")
    public void updateAdvertiser(@PathVariable Long advertiserId, @RequestBody AdvertiserEdit advertiserEdit) {
        advertiserService.updateAdvertiser(advertiserId, advertiserEdit);

    }

    @DeleteMapping("/advertisers/{advertiserId}")
    public void deleteAdvertiser(@PathVariable Long advertiserId) {
        advertiserService.deleteAdvertiser(advertiserId);
    }
}
