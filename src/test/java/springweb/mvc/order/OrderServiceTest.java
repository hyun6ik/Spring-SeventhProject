package springweb.mvc.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springweb.mvc.AppConfig;
import springweb.mvc.domain.Grade;
import springweb.mvc.domain.Member;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;
import springweb.mvc.service.OrderService;
import springweb.mvc.service.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
    }

    @Test
    public void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
