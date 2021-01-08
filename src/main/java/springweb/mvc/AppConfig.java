package springweb.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springweb.mvc.discount.DiscountPolicy;
import springweb.mvc.discount.FixDiscountPolicy;
import springweb.mvc.discount.RateDiscountPolicy;
import springweb.mvc.repository.MemoryMemberRepository;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;
import springweb.mvc.service.OrderService;
import springweb.mvc.service.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
