package com.swclass.hello.core.singlton;

import com.swclass.hello.core.AppConfig;
import com.swclass.hello.core.member.MemberRepository;
import com.swclass.hello.core.member.MemberServiceImpl;
import com.swclass.hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository).isSameAs(memberRepository1);
    }

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig);

//        assertThat(appConfig).isEqualTo(AppConfig.class);
    }
}
