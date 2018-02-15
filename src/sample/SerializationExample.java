package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

//	private static final long serialVersionUID = 100L;
	String name;
//	int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}

}

class SubClass extends Employee {

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		throw new NotSerializableException();
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new NotSerializableException();
	}
}

public class SerializationExample {

	public static void main(String... args) throws Exception {
		SerializationExample serializationExample = new SerializationExample();
//		serializationExample.serializeObject();
		serializationExample.deserializeObject();
	}

	private void serializeObject() throws FileNotFoundException, IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(new File("/home/ttn/emp.ser")));
		Employee e = new Employee();
		e.setName("Old Name");
		objectOutputStream.writeObject(e);
//		objectOutputStream.close();
		objectOutputStream  = new ObjectOutputStream(
				new FileOutputStream(new File("/home/ttn/emp.ser")));
		e.setName("Saurabh");
		objectOutputStream.writeObject(e);
		objectOutputStream.close();

	}

	private void deserializeObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/home/ttn/emp.ser")));
		Employee e = (Employee) objectInputStream.readObject();
		System.out.println("Employee Name: " + e.name);
		objectInputStream.close();
	}
}








