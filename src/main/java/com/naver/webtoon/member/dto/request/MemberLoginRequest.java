package com.naver.webtoon.member.dto.request;

import lombok.Getter;

@Getter
public class MemberLoginRequest {

    private String username;
    private String password;

    public MemberLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
