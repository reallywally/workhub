package com.wally.workhub.domain.advertiser.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wally.workhub.domain.advertiser.entity.Advertiser;
import com.wally.workhub.domain.advertiser.model.AdvertiserSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static com.wally.workhub.domain.advertiser.entity.QAdvertiser.advertiser;

@RequiredArgsConstructor
public class AdvertiserRepositoryImpl implements AdvertiserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Advertiser> getList(AdvertiserSearch advertiserSearch) {
        long totalCount = jpaQueryFactory.select(advertiser.count())
                .from(advertiser)
                .fetchFirst();

        List<Advertiser> items = jpaQueryFactory.selectFrom(advertiser)
                .limit(advertiserSearch.getSize())
                .offset(advertiserSearch.getOffset())
                .orderBy(advertiser.id.desc())
                .fetch();

        return new PageImpl<>(items, advertiserSearch.getPageable(), totalCount);
    }
}
