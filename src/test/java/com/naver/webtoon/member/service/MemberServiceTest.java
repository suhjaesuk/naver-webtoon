package com.naver.webtoon.member.service;

import com.naver.webtoon.member.dto.request.MemberSignUpRequest;
import com.naver.webtoon.member.entity.Member;
import com.naver.webtoon.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.naver.webtoon.member.fixture.MemberFixture.PASSWORD;
import static com.naver.webtoon.member.fixture.MemberFixture.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    MemberService memberService;
    @Mock
    MemberRepository memberRepository;
    @Mock
    PasswordEncoder passwordEncoder;

    @DisplayName("회원 가입 시 정상 케이스")
    @Test
    public void signUp() {
        MemberSignUpRequest request = new MemberSignUpRequest(USERNAME, PASSWORD);
        String encryptedPassword = passwordEncoder.encode(request.getPassword());
        Member member = request.toMember(encryptedPassword);

        when(memberRepository.save(any())).thenReturn(member);

        Member expectedMember = memberRepository.save(member);

        assertThat(expectedMember.getUsername()).isEqualTo(request.getUsername());
        assertThat(expectedMember.getPassword()).isEqualTo(encryptedPassword);
        assertThat(expectedMember.getCookieCount()).isEqualTo(0);
    }

    @DisplayName("회원 가입 시 중복된 이름이 있다면 예외를 반환한다.")
    @Test
    public void throwIfExistDuplicatedUsernameWhenSignUp() {
        //TODO: implements
    }

    @DisplayName("로그인 시 정상 케이스.")
    @Test
    public void login() {
        //TODO: implements
    }

    @DisplayName("로그인 시 회원을 찾지 못하면 예외를 반환한다.")
    @Test
    public void throwIfCannotFoundMemberWhenLogin() {
        //TODO: implements
    }

    @DisplayName("로그인 시 비밀번호가 다르면 예외를 반환한다.")
    @Test
    public void throwIfDifferentPasswordWhenLogin() {
        //TODO: implements
    }
}
