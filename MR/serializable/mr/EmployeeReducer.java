package MR.serializable.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class EmployeeReducer extends Reducer<LongWritable, Employee, LongWritable, Employee> {

	@Override
	protected void reduce(LongWritable k3, Iterable<Employee> v3,Context context)
			throws IOException, InterruptedException {
		// 
		for(Employee e : v3){
			context.write(k3, e);
		}
	}
	
	

}
