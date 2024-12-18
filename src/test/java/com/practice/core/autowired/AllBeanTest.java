package com.practice.core.autowired;

import com.practice.core.AutoAppConfig;
import com.practice.core.discount.DiscountPolicy;
import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanTest {

  @Test
  void finaAllBean() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

    DiscountService discountService = ac.getBean(DiscountService.class);
    Member member = new Member(1L, "1", Grade.VIP);
    int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

    Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
    Assertions.assertThat(discountPrice).isEqualTo(1000);
  }

  static class DiscountService {

    private final Map<String, DiscountPolicy> policyMap;

    DiscountService(Map<String, DiscountPolicy> policyMap) {
      this.policyMap = policyMap;

      System.out.println("policyMap = " + policyMap);
    }

    public int discount(Member member, int price, String discountCode) {
      DiscountPolicy discountPolicy = policyMap.get(discountCode);

      System.out.println("discountPolicy = " + discountPolicy);

      return discountPolicy.discount(member, price);
    }
  }
}
