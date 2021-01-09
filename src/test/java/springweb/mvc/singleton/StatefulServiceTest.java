package springweb.mvc.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    
    @Test
    public void statefulServiceSingleton() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        //when
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);
        //then
        //ThreadA : 사용자A 주문 금액 조회
//        int price1 = statefulService1.getPrice();
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);
        //ThreadB : 사용자B 주문 금액 조회
//        int price2 = statefulService2.getPrice();
//        System.out.println("price2 = " + price2);
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    @Configuration
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}