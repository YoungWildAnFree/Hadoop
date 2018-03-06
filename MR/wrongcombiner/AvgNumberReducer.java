package MR.wrongcombiner;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgNumberReducer extends Reducer<Text, LongWritable, Text, DoubleWritable> {

	@Override
	protected void reduce(Text k3, Iterable<LongWritable> v3,Context context) throws IOException, InterruptedException {
		//
		int count = 0;
		long total = 0;
		for(LongWritable v : v3){
			total =total+v.get();
			count++;
		}
		
		context.write(new Text("Avg Value is"), new DoubleWritable(total/count));
	}
	

}
