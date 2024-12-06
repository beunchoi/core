package com.practice.core.member;

import com.practice.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }

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