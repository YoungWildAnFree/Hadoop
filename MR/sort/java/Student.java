package MR.sort.java;

public class Student implements Comparable<Student>{
	private int stuID;
	private String stuname;
	private int age;
	
	public Student(){
		
	}
	
	
	
	@Override
	public String toString() {
		//
		return "["+this.stuID+"\t"+this.stuname+"\t"+this.age+"]";
	}



	@Override
	public int compareTo(Student o) {
		//
		if(this.age >= o.getAge()){
			return 1;
		}else{
			return -1;
		}
	}
	
	
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



	
	

}
