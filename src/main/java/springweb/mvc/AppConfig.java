package springweb.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springweb.mvc.discount.DiscountPolicy;
import springweb.mvc.discount.FixDiscountPolicy;
import springweb.mvc.discount.RateDiscountPolicy;
import springweb.mvc.repository.MemberRepository;
import springweb.mvc.repository.MemoryMemberRepository;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;
import springweb.mvc.service.OrderService;
import springweb.mvc.service.OrderServiceImpl;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //결과적으로 각각 다른 2개의 MemoryMemberRepository가 생성되면서 싱글톤이 깨지는 것 처럼 보인다.

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository
    //but 1번씩만 호출함

    @Bean
    public MemberService memberService(){
//        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
//        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
