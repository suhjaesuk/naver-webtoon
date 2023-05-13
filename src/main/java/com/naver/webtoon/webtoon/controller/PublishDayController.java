package com.naver.webtoon.webtoon.controller;

import com.naver.webtoon.common.response.SuccessMessage;
import com.naver.webtoon.webtoon.dto.request.PublishDayRegisterRequest;
import com.naver.webtoon.webtoon.service.PublishDayService;
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
public class PublishDayController {

    private final PublishDayService publishDayService;

    @PostMapping("/publish-day")
    public ResponseEntity<SuccessMessage<Void>> registerPublishDay(@RequestBody PublishDayRegisterRequest request) {
        publishDayService.registerPublishDay(request);
        return new ResponseEntity<>(new SuccessMessage<>("연재일등록성공",null), HttpStatus.CREATED);
    }
}
