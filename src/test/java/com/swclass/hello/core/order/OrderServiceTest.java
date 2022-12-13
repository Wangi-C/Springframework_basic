package com.swclass.hello.core.order;

import com.swclass.hello.core.AppConfig;
import com.swclass.hello.core.member.Grade;
import com.swclass.hello.core.member.Member;
import com.swclass.hello.core.member.MemberService;
import com.swclass.hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscoutPrice()).isEqualTo(1000);
    }
    
    @Test
    void fieldInjectionTest() {
        // 상황 : OrderService 객체의 Respository를 다른 객체로 의존주입하여 사용하고 싶다.
//        OrderServiceImpl orderService = new OrderServiceImpl();

        // 필드 주입일 경우, 필드에 대한 주입이 어렵기 때문에 nullPointerException이 발생
        // -> 따로 OrderServiceImpl에 setter 메소드를 추가해주어야 한다.
//        assertThrows(NullPointerException.class,
//                () -> orderService.createOrder(1L, "itemA", 10000));
    }
    
}
