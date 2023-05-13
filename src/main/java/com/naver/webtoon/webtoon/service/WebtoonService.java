package com.naver.webtoon.webtoon.service;

import com.naver.webtoon.webtoon.dto.request.WebtoonRegisterRequest;
import com.naver.webtoon.webtoon.repository.WebtoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WebtoonService {

    private final WebtoonRepository webtoonRepository;

    @Transactional
    public void registerWebtoon(WebtoonRegisterRequest request) {
        // TODO: implements
    }
}
