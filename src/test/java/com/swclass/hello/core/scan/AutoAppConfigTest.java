package com.swclass.hello.core.scan;


import com.swclass.hello.core.AutoAppConfig;
import com.swclass.hello.core.member.MemberRepository;
import com.swclass.hello.core.member.MemberService;
import com.swclass.hello.core.order.OrderService;
import com.swclass.hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String bean : beanDefinitionNames) {
//            System.out.println("bean = " + bean);
//        }

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean("orderServiceImpl",OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
