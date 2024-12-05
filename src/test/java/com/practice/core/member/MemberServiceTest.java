package com.practice.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

  MemberService memberService = new MemberServiceImpl();

  @Test
  void join() {
    // given
    Member member = new Member(1L, "memberA", Grade.VIP);

    // when
    memberService.join(member);
    Member savedMember = memberService.findMember(member.getId());

    // then
    Assertions.assertThat(member).isEqualTo(savedMember);

  }

  @Test
  void findMember() {
    // given

    // when

    // then
  }
}