package springweb.mvc.discount;

import springweb.mvc.domain.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
