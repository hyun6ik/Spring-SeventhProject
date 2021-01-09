package springweb.mvc.beenfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springweb.mvc.AppConfig;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() throws Exception {
        //given
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회회")
   public void findBeanByType() throws Exception {
        //given
        MemberService memberService = ac.getBean(MemberService.class);
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2() throws Exception {
        //given
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    public void findBeanByNameX() throws Exception {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));


    }

}
