package com.swclass.hello.core.order;

import com.swclass.hello.core.discount.DiscountPolicy;
import com.swclass.hello.core.member.Member;
import com.swclass.hello.core.member.MemberRepository;
import com.swclass.hello.core.member.MemberServiceImpl;
import com.swclass.hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //@Autowired
    private final MemberRepository memberRepository;
    //@Autowired
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy fixDiscountPolicy) {
        // 파라미터에 맞는 bean을 타입으로 조회를 한다.

        // 필드값이 final 변수이면 생성자 주입시, compile에러를 미리 받을 수 있다.
        // 필드값에 대해 주입을 하지 않으면 compile에러발생.
        this.memberRepository = memberRepository;
        this.discountPolicy = fixDiscountPolicy;
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
/**
 * 롬복과 최신트렌드
 * 필드에 final키워드 사용을 했을때 반드시 생성자를 만들어줘야하는 약간의 불편함이 존재한다.
 * 필드에 @Autowired를 하면 얼마나 편해 -> Lombok 라이브러리 사용.
 *
 * Lombok (@RequiredArgsConstructor) -> 필드값 중 final이 있으면 해당 필드에 대한 생성자를 자동으로 만들어준다.
 * ctrl + f12 를 누르고 생성자가 만들어졌는지 확인해보자.
 * **/
