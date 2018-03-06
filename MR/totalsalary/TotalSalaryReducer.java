package MR.totalsalary;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.reduce.WrappedReducer.Context;
													//部门号    			 薪水 			 部门号 		部门工资总和
public class TotalSalaryReducer extends Reducer<LongWritable, LongWritable, LongWritable, LongWritable> {

	@Override
	protected void reduce(LongWritable k3, Iterable<LongWritable> v3,Context context)
			throws IOException, InterruptedException {
		// 
		long total = 0;
		for(LongWritable v : v3){
			total = total + v.get(); 
		}
		
		context.write(k3, new LongWritable(total));
	}

}
