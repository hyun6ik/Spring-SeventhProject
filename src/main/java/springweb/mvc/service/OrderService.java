package springweb.mvc.service;

import springweb.mvc.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
