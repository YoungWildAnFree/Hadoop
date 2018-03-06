package MR.wc;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//public class WordCountReducer extends Reducer<k3, v3, k4, v4>{

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable>{

	@Override
	protected void reduce(Text k3, Iterable<LongWritable> v3,Context context) throws IOException, InterruptedException {
		// context����reduce�������� 
		//���� mapper
		//���� HDFS
		
		//��v3���
		long total = 0;
		for(LongWritable v:v3){
			total = total+v.get();
		}
		
		context.write(k3, new LongWritable(total));
	}
	

}
