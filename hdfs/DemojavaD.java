package demo;



//ִ�� java -Duser=tom -Dage=23 DemoJavaD
//java -D �����ڳ�������λ�û�ñ���
public class DemojavaD {

	
	public static void main(String[] args){
		method1();
	}
	
	public static void method1(){
		//��������
		String user = System.getProperty("user");
		String age = System.getProperty("age");
		
		System.out.println(user + "   "+ age);
	}
}
