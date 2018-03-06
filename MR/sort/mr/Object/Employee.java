package MR.sort.mr.Object;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class Employee implements WritableComparable<Employee> {
//	数据：7654,MARTIN,SALESMAN,7698,1981/9/28,1250,1400,30
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	
	
	@Override
	public String toString() {
		// 
		return "["+this.ename+"\t"+this.sal+"\t"+this.deptno+"]";
	}
	
	
	//实现排序规则
//	@Override
//	public int compareTo(Employee o) {
//		
//		//按照薪水列 升序
//		if(this.sal >= o.getSal()){
//			return 1;
//		}else{
//			return -1;
//		}
//	}
//	
	
	//实现两个列的排序
	public int compareTo(Employee o) {
		//按照部门号排序
		//注意这里没有等号
		if(this.deptno > o.getDeptno()){
			return 1;
		}else if(this.deptno < o.getDeptno()){
			return -1;
		}
		
		//表示 部门号相等
		//排序规则的第二个条件薪水 
		//在最后一个规则条件  加上等号 
		if(this.sal >= o.getSal()){
			return 1;
		}else{
			return -1;
		}
	}
	
	
	
	//反序列化与序列化 顺序必须一致
	@Override
	public void readFields(DataInput in) throws IOException {
		// 反序列化
		this.empno = in.readInt();
		this.ename = in.readUTF();
		this.job = in.readUTF();
		this.mgr = in.readInt();
		this.hiredate = in.readUTF();
		this.sal = in.readInt();
		this.comm = in.readInt();
		this.deptno = in.readInt();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// 序列化
		out.writeInt(this.empno);
		out.writeUTF(this.ename);
		out.writeUTF(this.job);
		out.writeInt(this.mgr);
		out.writeUTF(this.hiredate);
		out.writeInt(this.sal);
		out.writeInt(this.comm);
		out.writeInt(this.deptno);
		
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	
	
	
}
