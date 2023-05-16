package com.naver.webtoon.webtoon.entity.enums;

import com.naver.webtoon.common.exception.WebtoonException;

import static com.naver.webtoon.common.exception.ErrorCode.NOT_FOUND_DAY_OF_THE_WEEK;

public enum DayOfTheWeek {

    MON,
    TUES,
    WED,
    THU,
    FRI,
    SAT,
    SUN,
    ;

    public static DayOfTheWeek toEnum(String dayOfTheWeek) {
        return switch (dayOfTheWeek) {
            case "MON" -> MON;
            case "TUES" -> TUES;
            case "WED" -> WED;
            case "THU" -> THU;
            case "FRI" -> FRI;
            case "SAT" -> SAT;
            case "SUN" -> SUN;
            default -> throw new WebtoonException(NOT_FOUND_DAY_OF_THE_WEEK);
        };
    }
}
