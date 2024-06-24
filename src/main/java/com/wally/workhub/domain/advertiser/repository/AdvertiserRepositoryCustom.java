package com.wally.workhub.domain.advertiser.repository;

import com.wally.workhub.domain.advertiser.entity.Advertiser;
import com.wally.workhub.domain.advertiser.model.AdvertiserSearch;
import org.springframework.data.domain.Page;

public interface AdvertiserRepositoryCustom {

    Page<Advertiser> getList(AdvertiserSearch advertiserSearch);
}
