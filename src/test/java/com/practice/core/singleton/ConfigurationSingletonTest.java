package com.practice.core.singleton;

import com.practice.core.AppConfig;
import com.practice.core.member.MemberRepository;
import com.practice.core.member.MemberServiceImpl;
import com.practice.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

  ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  void configurationTest() {
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    System.out.println(orderService.getMemberRepository() + " "
        + memberService.getMemberRepository() + " "
        + memberRepository);

    Assertions.assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    Assertions.assertThat(memberRepository).isSameAs(memberService.getMemberRepository());
  }
}
