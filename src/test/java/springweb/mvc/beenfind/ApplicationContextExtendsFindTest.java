package springweb.mvc.beenfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springweb.mvc.discount.DiscountPolicy;
import springweb.mvc.discount.FixDiscountPolicy;
import springweb.mvc.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    
    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면, 중복 오류가 발생한다.")
    public void findBeanByParantTypeDuplicate() throws Exception {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
        
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    public void findBeanByParentTypeBeanName() throws Exception {
        //given
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        //then
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("특정 하위 타입으로 조회 (안좋은 방법)")
    public void findBeanBySubType() throws Exception {
        //given
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        //then
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
   public void findAllBeanByParentType() throws Exception {
        //given
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        //then
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    public void findAllBeanByObjectTy() throws Exception {
        //given
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        //then
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }


    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
    }
}
