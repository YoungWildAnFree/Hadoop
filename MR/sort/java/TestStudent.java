package MR.sort.java;

import java.util.Arrays;

public class TestStudent {

	public static void main(String[] args) {
		// 
		Student s1 = new Student();
		s1.setStuID(1);
		s1.setStuname("Tom");
		s1.setAge(23);
		
		
		Student s2 = new Student();
		s2.setStuID(2);
		s2.setStuname("Mary");
		s2.setAge(25);
		
		Student s3 = new Student();
		s3.setStuID(3);
		s3.setStuname("Mike");
		s3.setAge(24);
		
		
		//����һ������
		Student[] list = {s1,s2,s3};
		//���ù�����
		Arrays.sort(list);
		//���
		
		for(Student s :list){
			System.out.println(s);
		}
	}

}
