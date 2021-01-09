package springweb.mvc.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springweb.mvc.AppConfig;
import springweb.mvc.repository.MemberRepository;
import springweb.mvc.service.MemberServiceImpl;
import springweb.mvc.service.OrderServiceImpl;

public class ConfigurationSingletonTest {


    @Test
    public void configurationTest() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        
        //then
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
        
    }
}
