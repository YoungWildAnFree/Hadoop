package MR.serializable.saltotal;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;


//≤ø√≈∫≈  
public class SalaryTotalReducer extends Reducer<LongWritable, Employee, LongWritable, LongWritable> {

	@Override
	protected void reduce(LongWritable k3, Iterable<Employee> v3,Context context)
			throws IOException, InterruptedException {
		
		long total = 0;
		for(Employee e :v3){
			total = total + e.getSal();	
		}
		
		context.write(k3,new LongWritable(total));
	}
	

}
