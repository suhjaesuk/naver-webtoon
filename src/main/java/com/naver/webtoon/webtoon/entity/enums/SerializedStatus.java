package com.naver.webtoon.webtoon.entity.enums;

import com.naver.webtoon.common.exception.WebtoonException;

import static com.naver.webtoon.common.exception.ErrorCode.NOT_FOUND_SERIALIZED_STATUS;

public enum SerializedStatus {

    연재중,
    휴재중,
    완결,
    ;

    public static SerializedStatus toEnum(String serializedStatus) {
        return switch (serializedStatus) {
            case "연재중" -> 연재중;
            case "휴재중" -> 휴재중;
            case "완결" -> 완결;
            default -> throw new WebtoonException(NOT_FOUND_SERIALIZED_STATUS);
        };
    }
}
