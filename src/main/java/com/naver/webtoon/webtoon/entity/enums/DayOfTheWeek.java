package com.naver.webtoon.webtoon.entity.enums;

import com.naver.webtoon.common.exception.WebtoonException;

import static com.naver.webtoon.common.exception.ErrorCode.NOT_FOUND_DAY_OF_THE_WEEK;

public enum DayOfTheWeek {

    월요일,
    화요일,
    수요일,
    목요일,
    금요일,
    토요일,
    일요일,
    ;

    public static DayOfTheWeek toEnum(String dayOfTheWeek) {
        return switch (dayOfTheWeek) {
            case "월요일" -> 월요일;
            case "화요일" -> 화요일;
            case "수요일" -> 수요일;
            case "목요일" -> 목요일;
            case "금요일" -> 금요일;
            case "토요일" -> 토요일;
            case "일요일" -> 일요일;
            default -> throw new WebtoonException(NOT_FOUND_DAY_OF_THE_WEEK);
        };
    }
}
