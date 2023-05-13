package com.naver.webtoon.webtoon.controller;

import com.naver.webtoon.common.response.SuccessMessage;
import com.naver.webtoon.webtoon.dto.request.WebtoonRegisterRequest;
import com.naver.webtoon.webtoon.service.WebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WebtoonController {

    private final WebtoonService webtoonService;

    @PostMapping("/webtoon")
    public ResponseEntity<SuccessMessage<Void>> registerWebtoon(@RequestBody WebtoonRegisterRequest request) {
        webtoonService.registerWebtoon(request);
        return new ResponseEntity<>(new SuccessMessage<>("웹툰등록성공",null), HttpStatus.CREATED);
    }
}
