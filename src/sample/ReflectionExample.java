package sample;

import java.lang.reflect.Field;

class Simple {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

public class ReflectionExample {

	public static void main(String args[]) throws Exception {
		ReflectionExample reflectionExample = new ReflectionExample();
//		reflectionExample.forName();
		reflectionExample.accessPrivateMember();
	}
	
	private void forName() throws ClassNotFoundException{
		Class c = Simple.class;
		System.out.println(c.getName());
	}
	
	private void accessPrivateMember() throws Exception{
		Simple simple=new Simple();
		simple.setName("dummy");
		
		Simple simple2=new Simple();
		simple2.setName("Danny");
		
		Field nameField = simple.getClass().getField("name");
		nameField.setAccessible(true);
		Object value = nameField.get(simple2);
		System.out.println(nameField.getType());
	}
}









