package com.practice.core.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

  ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

  @Test
  void order() {
    StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
    StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

    statefulService1.order("1", 10000);
    statefulService2.order("2", 20000);

    int price = statefulService1.getPrice();

    Assertions.assertThat(price).isEqualTo(20000); // 특정 클라이언트로 인해 값이 변경
  }

  static class TestConfig {

    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}