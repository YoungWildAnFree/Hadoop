package MR.wrongcombiner;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AvgNumberMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		// 
		String data = value1.toString();
		context.write(new Text("my number"), new LongWritable(Long.parseLong(data)));
	}
	

}
