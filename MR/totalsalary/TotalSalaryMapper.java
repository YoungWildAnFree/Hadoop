package MR.totalsalary;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TotalSalaryMapper extends Mapper<LongWritable, Text, LongWritable, LongWritable> {

	@Override
	protected void map(LongWritable key1, Text value1,Context context)
			throws IOException, InterruptedException {
		// Êý¾Ý£º7654,MARTIN,SALESMAN,7698,1981/9/28,1250,1400,30
		String str = value1.toString();
		String[] words = str.split(",");
		
		context.write(new LongWritable(Long.parseLong(words[7])), new LongWritable(Long.parseLong(words[5])));
		
		
	}
	

}
