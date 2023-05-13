package com.naver.webtoon.webtoon.service;

import com.naver.webtoon.webtoon.dto.request.PublishDayRegisterRequest;
import com.naver.webtoon.webtoon.entity.PublishDay;
import com.naver.webtoon.webtoon.repository.PublishDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PublishDayService {

    private final PublishDayRepository publishDayRepository;

    @Transactional
    public void registerPublishDay(PublishDayRegisterRequest request) {
        PublishDay publishDay = request.toPublishDay();

        publishDayRepository.save(publishDay);
    }
}
