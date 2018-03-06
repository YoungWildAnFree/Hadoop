package MR.sort.mr.Object;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class SortEmployeeMapper extends Mapper<LongWritable, Text, Employee, NullWritable> {

	@Override
	protected void map(LongWritable key1, Text value1,Context context)
			throws IOException, InterruptedException {
		// 数据：7654,MARTIN,SALESMAN,7698,1981/9/28,1250,1400,30
				String str = value1.toString();
				String[] words = str.split(",");
				
				//创建员工对象
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
				
				//输出mapper的记过k2员工对象   v2 空值
				context.write(e, NullWritable.get());
	}
	
	

}
