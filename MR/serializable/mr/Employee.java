package MR.serializable.mr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Employee implements Writable {
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
