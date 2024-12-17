package com.practice.core.componentscan;

import com.practice.core.AutoAppConfig;
import com.practice.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

  @Test
  void basicScan() {
    OrderService orderService = ac.getBean(OrderService.class);

    Assertions.assertThat(orderService).isInstanceOf(OrderService.class);
  }
}
