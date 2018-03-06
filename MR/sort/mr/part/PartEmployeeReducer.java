package MR.sort.mr.part;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

//												k3���ź�                         v3ĳ�������е�Ա��
public class PartEmployeeReducer extends Reducer<LongWritable, Employee, LongWritable, Employee> {

	@Override
	protected void reduce(LongWritable k3, Iterable<Employee> v3, Context context)
			throws IOException, InterruptedException {
		//��������ļǹ�ֱ�������hdfs
		for(Employee e : v3){
			context.write(k3, e);
		}
	}
	

}
