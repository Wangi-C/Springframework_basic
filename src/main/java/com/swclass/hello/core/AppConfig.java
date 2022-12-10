package com.swclass.hello.core;

import com.swclass.hello.core.discount.DiscountPolicy;
import com.swclass.hello.core.discount.FixDiscountPolicy;
import com.swclass.hello.core.discount.RateDiscountPolicy;
import com.swclass.hello.core.member.MemberRepository;
import com.swclass.hello.core.member.MemberService;
import com.swclass.hello.core.member.MemberServiceImpl;
import com.swclass.hello.core.member.MemoryMemberRepository;
import com.swclass.hello.core.order.OrderService;
import com.swclass.hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
//    애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고 연결하는 책임을 가지는 별고의 설정 클래스.

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberSerivce()");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository()");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderSerivce()");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
