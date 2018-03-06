package MR.sort.mr.part;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;



// 										k ��v����map�����
public class EmployeePatitionner extends Partitioner<LongWritable, Employee>{

	@Override
	public int getPartition(LongWritable k2, Employee v2, int numPart) {
		// numPart������������
		//����Ա���Ĳ��ź� ��������
		
		int deptno = v2.getDeptno();
		
		if(deptno == 10){
			return 1%numPart;
		}else if(deptno == 20){
			return 2%numPart;
		}else{
			return 3%numPart;
		}
		
	}
	

}
