package springweb.mvc.autowired;

import com.sun.istack.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springweb.mvc.domain.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    public void AutowiredOption() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        //when

        //then

    }

    static class TestBean{
        //1.@Autowired(required = false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("member = " + member);
        }
        //2. org.springframework.lnag.@Nullable : 자동 주입할 대상이 없으면 null이 입력된다.
        @Autowired(required = false)
        public void setNoBean2(@Nullable Member member){
            System.out.println("member = " + member);
        }
        //3. Optional<> : 자동 주입할 대상이 없으면 Optional.empty 가 입력된다.
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member){
            System.out.println("member = " + member);
        }
    }
}
