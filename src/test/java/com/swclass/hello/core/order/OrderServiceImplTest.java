package com.swclass.hello.core.order;

import com.swclass.hello.core.discount.FixDiscountPolicy;
import com.swclass.hello.core.member.Grade;
import com.swclass.hello.core.member.Member;
import com.swclass.hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOreder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }
}