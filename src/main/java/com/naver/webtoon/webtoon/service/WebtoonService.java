package com.naver.webtoon.webtoon.service;

import com.naver.webtoon.common.exception.WebtoonException;
import com.naver.webtoon.webtoon.dto.request.WebtoonRegisterRequest;
import com.naver.webtoon.webtoon.entity.Author;
import com.naver.webtoon.webtoon.entity.HashTag;
import com.naver.webtoon.webtoon.entity.PublishingDay;
import com.naver.webtoon.webtoon.entity.Webtoon;
import com.naver.webtoon.webtoon.entity.WebtoonHashTag;
import com.naver.webtoon.webtoon.entity.WebtoonPublishingDay;
import com.naver.webtoon.webtoon.entity.enums.DayOfTheWeek;
import com.naver.webtoon.webtoon.repository.AuthorRepository;
import com.naver.webtoon.webtoon.repository.HashTagRepository;
import com.naver.webtoon.webtoon.repository.PublishingDayRepository;
import com.naver.webtoon.webtoon.repository.WebtoonHashTagRepository;
import com.naver.webtoon.webtoon.repository.WebtoonPublishingDayRepository;
import com.naver.webtoon.webtoon.repository.WebtoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.naver.webtoon.common.exception.ErrorCode.NOT_FOUND_AUTHOR;
import static com.naver.webtoon.common.exception.ErrorCode.NOT_FOUND_HASH_TAG;
import static com.naver.webtoon.common.exception.ErrorCode.NOT_FOUND_PUBLISH_DAY;

@Service
@RequiredArgsConstructor
public class WebtoonService {

    private final AuthorRepository authorRepository;
    private final WebtoonRepository webtoonRepository;
    private final PublishingDayRepository publishingDayRepository;
    private final WebtoonPublishingDayRepository webtoonPublishingDayRepository;
    private final HashTagRepository hashTagRepository;
    private final WebtoonHashTagRepository webtoonHashTagRepository;

    @Transactional
    public void registerWebtoon(WebtoonRegisterRequest request) {
        Author author = authorRepository.findByName(request.getAuthor()).orElseThrow(
                () -> new WebtoonException(NOT_FOUND_AUTHOR));

        Webtoon webtoon = request.toWebtoon(author);

        webtoonRepository.save(webtoon);

        for (String dayOfTheWeek : request.getPublishDay()) {
            DayOfTheWeek dayOfTheWeekEnum = DayOfTheWeek.toEnum(dayOfTheWeek);
            PublishingDay publishingDay = publishingDayRepository.findByDayOfTheWeek(dayOfTheWeekEnum).orElseThrow(
                    () -> new WebtoonException(NOT_FOUND_PUBLISH_DAY));

            WebtoonPublishingDay webtoonPublishingDay = request.toWebtoonPublishingDay(webtoon, publishingDay);

            webtoonPublishingDayRepository.save(webtoonPublishingDay);
        }

        for (String name : request.getHashTag()) {
            HashTag hashTag = hashTagRepository.findByName(name).orElseThrow(
                    () -> new WebtoonException(NOT_FOUND_HASH_TAG));

            WebtoonHashTag webtoonHashTag = request.toWebtoonHashTag(webtoon,hashTag);

            webtoonHashTagRepository.save(webtoonHashTag);
        }
    }
}
