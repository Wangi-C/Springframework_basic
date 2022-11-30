package com.swclass.hello.core.singlton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class StatefulServiceTest {

    @Test
    void statfulServiceSingleton() {
        /*
        * 스프링은 항상 무상태로 설계해야한다.
        * */

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userAPrice = statefulService1.order("userA", 1000);
        int userBPrice = statefulService2.order("userB", 2000);

//        int price = statefulService1.getPrice();

        Assertions.assertThat(userAPrice).isEqualTo(1000);
    }

    @Configuration
    static class TestConfig {
        @Bean()
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
