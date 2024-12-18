package com.practice.core.order;

import static org.junit.jupiter.api.Assertions.*;

import com.practice.core.discount.FixDiscountPolicy;
import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import com.practice.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

  @Test
  void createOrder() {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    memberRepository.save(new Member(1L,"1", Grade.VIP));

    // 생성자 주입으로 하면 스프링 없는 테스트에서도 컴파일 단계에서 어떤 객체들을 주입해야 하는지 바로 알 수 있다
    OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "12", 10000);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}