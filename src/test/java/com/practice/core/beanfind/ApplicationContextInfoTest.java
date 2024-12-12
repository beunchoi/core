package com.practice.core.beanfind;

import com.practice.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 조회")
  void findAllBean() {
    String[] definitionNames = ac.getBeanDefinitionNames();
    for (String definitionName : definitionNames) {
      Object bean = ac.getBean(definitionName);

      System.out.println("definitionName = " + definitionName);
    }
  }

  @Test
  @DisplayName("모든 빈 조회")
  void findApplicationBean() {
    String[] definitionNames = ac.getBeanDefinitionNames();
    for (String definitionName : definitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(definitionName);

      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {

        System.out.println("definitionName = " + definitionName);
      }
    }
  }

}
