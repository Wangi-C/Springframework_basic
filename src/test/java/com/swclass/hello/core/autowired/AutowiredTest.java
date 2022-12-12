package com.swclass.hello.core.autowired;

import com.swclass.hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        // Member.class 는 Component Scan 대상이 아니므로 @Autowired만 있을 경우, 오류가 발생한다.
        // 의존관계 빈이 없을 경우, 수정자 메소드 자체가 호출이 되지 않는다.
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member1 = " + member);
        }

        // 수정자 호출은 되지만 null로 들어가진다.
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 = " + member);
        }

        //수정자 호출은 되지만 null -> Optional.empty 값으로 들어가진다.
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member3 = " + member);
        }
    }
}
