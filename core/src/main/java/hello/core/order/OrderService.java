package hello.core.order;

public interface OrderService {
	
	// 클라이언트가 주문한 결과를 반환
	Order createOrder(Long memberId, String itemName, int itemPrice);

}
