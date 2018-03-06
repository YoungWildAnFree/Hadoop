package demo;



//执行 java -Duser=tom -Dage=23 DemoJavaD
//java -D 可以在程序任意位置获得变量
public class DemojavaD {

	
	public static void main(String[] args){
		method1();
	}
	
	public static void method1(){
		//在这里获得
		String user = System.getProperty("user");
		String age = System.getProperty("age");
		
		System.out.println(user + "   "+ age);
	}
}
