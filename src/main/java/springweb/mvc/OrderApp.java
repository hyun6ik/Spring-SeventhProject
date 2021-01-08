package springweb.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springweb.mvc.discount.DiscountPolicy;
import springweb.mvc.domain.Grade;
import springweb.mvc.domain.Member;
import springweb.mvc.order.Order;
import springweb.mvc.service.MemberService;
import springweb.mvc.service.MemberServiceImpl;
import springweb.mvc.service.OrderService;
import springweb.mvc.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
