package springweb.mvc.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springweb.mvc.AppConfig;
import springweb.mvc.service.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    //싱글톤 패턴 : 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
    // private생성자를 사용해서 외부에서 임의로 new키워드를 사용하지 못하도록 막야아한다.


    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    public void pureContatiner() throws Exception {
        //given
        AppConfig appconfig = new AppConfig();
        //when
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appconfig.memberService();
        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appconfig.memberService();
        //then
        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void SingletonServiceTest() throws Exception {
        //given
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //when
        
        //then
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);

        //same == 참조
        //equal
    }
}
