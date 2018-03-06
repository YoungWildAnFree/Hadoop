package MR.sort.mr.part;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

//												k3部门号                         v3某个分区中的员工
public class PartEmployeeReducer extends Reducer<LongWritable, Employee, LongWritable, Employee> {

	@Override
	protected void reduce(LongWritable k3, Iterable<Employee> v3, Context context)
			throws IOException, InterruptedException {
		//将分区后的记过直接输出到hdfs
		for(Employee e : v3){
			context.write(k3, e);
		}
	}
	

}
