package com.swclass.hello.core.singlton;

import com.swclass.hello.core.AppConfig;
import com.swclass.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    /**
     * 스프링이 없는 순수한 컨테이너로 웹 애플리케이션으로 만들면
     * 싱글톤이 없기 때문에, 요청이 있을때마다 객체가 생성된다.
     * -> 자원낭비
     *
     * 해결책 -> 객체는 하나만 만들고 해당 객체를 공유하는 형태
     * **/
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }
}
