package com.wally.workhub.domain.advertiser.repository;

import com.wally.workhub.domain.advertiser.model.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvertiserRepository extends JpaRepository<Advertiser, Long> {
    Optional<Advertiser> findByBusinessNumber(String businessNumber);
}
