package MR.serializable.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// 
		Student s = new Student();
		s.setStuID(1);
		s.setStuName("tom");
		
		
		
		FileOutputStream fileout = new FileOutputStream("e:\\workspace\\MR\\student.oo");
		ObjectOutputStream out = new ObjectOutputStream(fileout);
		
		out.writeObject(s);
		
		out.close();
//		fileout.close();
		
		
		FileInputStream filein = new FileInputStream("e:\\workspace\\MR\\student.oo");
		ObjectInputStream in = new ObjectInputStream(filein);
		
		Student r = (Student) in.readObject();
		System.out.println(r.getStuID()+r.getStuName());
		
		in.close();
		filein.close();

	}

}
