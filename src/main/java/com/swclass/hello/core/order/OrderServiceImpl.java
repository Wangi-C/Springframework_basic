package com.swclass.hello.core.order;

import com.swclass.hello.core.discount.DiscountPolicy;
import com.swclass.hello.core.member.Member;
import com.swclass.hello.core.member.MemberRepository;
import com.swclass.hello.core.member.MemberServiceImpl;
import com.swclass.hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //@Autowired
    private final MemberRepository memberRepository;
    //@Autowired
    private final DiscountPolicy discountPolicy;

    /*@Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
