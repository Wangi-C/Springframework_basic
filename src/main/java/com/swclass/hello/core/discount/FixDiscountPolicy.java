package com.swclass.hello.core.discount;

import com.swclass.hello.core.member.Grade;
import com.swclass.hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            //enum 은 '==' 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
