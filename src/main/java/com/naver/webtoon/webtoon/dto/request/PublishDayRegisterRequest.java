package com.naver.webtoon.webtoon.dto.request;

import com.naver.webtoon.webtoon.entity.PublishDay;
import com.naver.webtoon.webtoon.entity.enums.DayOfTheWeek;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PublishDayRegisterRequest {

    private DayOfTheWeek dayOfTheWeek;

    public PublishDay toPublishDay() {
        return PublishDay.builder()
                .dayOfTheWeek(dayOfTheWeek)
                .build();
    }

    public PublishDayRegisterRequest(DayOfTheWeek dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
