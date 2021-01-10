package springweb.mvc.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springweb.mvc.discount.FixDiscountPolicy;
import springweb.mvc.domain.Grade;
import springweb.mvc.domain.Member;
import springweb.mvc.repository.MemoryMemberRepository;
import springweb.mvc.service.OrderServiceImpl;

public class OrderServiceImplTest {

    @Test
    public void createOrder() throws Exception {
        //given
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"member1", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        //when
        Order order = orderService.createOrder(1L, "itemA", 10000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
