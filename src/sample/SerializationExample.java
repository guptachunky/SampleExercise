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

class Employee implements Serializable{
	
	private static final long serialVersionUID = 100L;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class SubClass extends Employee {
	
	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		throw new NotSerializableException();
	}

	private void writeObject(ObjectOutputStream oos)
			throws IOException {
		throw new NotSerializableException();
	}
}

public class SerializationExample {

	public static void main(String...args) throws Exception{
		SerializationExample serializationExample = new SerializationExample();
//		serializationExample.serializeObject();
		serializationExample.deserializeObject();
	}
	
	private void serializeObject() throws FileNotFoundException, IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("/home/ttn/emp.ser")));
//		Employee e = new Employee();
//		e.setName("Danny");
//		objectOutputStream.writeObject(e);
//		e.setName("John");
		SubClass subClass = new SubClass();
		subClass.setName("Danny");
		objectOutputStream.writeObject(subClass);
		objectOutputStream.close();
		
		
	}
	
	private void deserializeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/home/ttn/emp.ser")));
		Employee e = (Employee) objectInputStream.readObject();
		System.out.println("Employee Name: " + e.name);
		objectInputStream.close();
	}
}
