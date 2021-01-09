package springweb.mvc.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springweb.mvc.AutoAppConfig;
import springweb.mvc.service.MemberService;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    public void basicScan() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //when
        MemberService memberService = ac.getBean(MemberService.class);
        //then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
