package sample;

interface Interface1 {
	public void method1();
	
//	public void method2();
	
//	default void method3(){System.out.println("called method3");}
	
//	static void method4(){System.out.println("called method4");}
}

class Dummy implements Interface1{

	@Override
	public void method1() {
		System.out.println("called method1");
	}
	
}
public class DefaultMethodExample {

	public static void main(String...args){
		Dummy dummy = new Dummy();
		dummy.method1();
//		dummy.method3();
//		Interface1.method4();
	}
}
