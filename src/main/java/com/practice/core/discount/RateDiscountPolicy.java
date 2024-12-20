package com.practice.core.discount;

import com.practice.core.annotation.MainDiscountPolicy;
import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import org.springframework.stereotype.Component;

@Component
//@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }

  }
}
