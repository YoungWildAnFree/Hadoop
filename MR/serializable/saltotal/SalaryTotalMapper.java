package MR.serializable.saltotal;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

																	// ���ź�     Ա������
public class SalaryTotalMapper extends Mapper<LongWritable, Text, LongWritable, Employee> {

	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		// �Ѷ�������ݷ�װ��һ��Ա������
		String str = value1.toString();
		String[] words = str.split(",");
		
		//����Ա������
		Employee e = new Employee();
		e.setEmpno(Integer.parseInt(words[0]));
		e.setEname(words[1]);
		e.setJob(words[2]);
		try{
			e.setMgr(Integer.parseInt(words[3]));
		}catch(Exception ex){
			e.setMgr(0);
		}
		e.setHiredate(words[4]);
		
		e.setSal(Integer.parseInt(words[5]));
		
		try{
			e.setComm(Integer.parseInt(words[6]));
		}catch(Exception ex){
			e.setComm(0);
		}
		
		e.setDeptno(Integer.parseInt(words[7]));
		
		//��� ���ź� Ա������
		context.write(new LongWritable(e.getDeptno()), e);
	}
	

}
