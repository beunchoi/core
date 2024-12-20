package com.practice.core.order;

import com.practice.core.AppConfig;
import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import com.practice.core.member.MemberService;
import com.practice.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

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
    // given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);
    // when
    Order order = orderService.createOrder(memberId, "itemA", 10000);
    // then
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}