package springweb.mvc.service;

import springweb.mvc.discount.DiscountPolicy;
import springweb.mvc.discount.FixDiscountPolicy;
import springweb.mvc.discount.RateDiscountPolicy;
import springweb.mvc.domain.Member;
import springweb.mvc.order.Order;
import springweb.mvc.repository.MemberRepository;
import springweb.mvc.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
