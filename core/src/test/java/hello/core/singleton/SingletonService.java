package hello.core.singleton;

public class SingletonService {
	
	// static���￡ ��ü�� 1���� �����صд�. 
	private static final SingletonService instance = new SingletonService();
	
	// public���� ��� ��ü �ν��Ͻ��� �ʿ��ϸ� �� static �޼��带 ���ؼ��� ��ȸ�ϵ��� ����Ѵ�.
	public static SingletonService getInstance() {
		return instance;
	}
	
	//�����ڸ� private���� �����ؼ� �ܺμ��� new Ű���带 ����� ��ü ������ ���ϰ� ���´�.
	private SingletonService(){
	}
	
	public void logic() {
		System.out.println("�̱��� ��ü ���� ȣ��");
	}
	

}
