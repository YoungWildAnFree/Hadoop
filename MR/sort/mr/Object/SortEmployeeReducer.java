package MR.sort.mr.Object;

import java.io.IOException;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;


public class SortEmployeeReducer extends Reducer<Employee, NullWritable,Employee, NullWritable> {

	@Override
	protected void reduce(Employee k3, Iterable<NullWritable> v3,Context context)
			throws IOException, InterruptedException {
		
		context.write(k3,NullWritable.get());
	}
	

}
