package hello.core.order;

public interface OrderService {
	
	// Ŭ���̾�Ʈ�� �ֹ��� ����� ��ȯ
	Order createOrder(Long memberId, String itemName, int itemPrice);

}
