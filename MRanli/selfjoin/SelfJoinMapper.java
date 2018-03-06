package MRanli.selfjoin;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SelfJoinMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		
		String data = value1.toString();
		String[] words = data.split(",");
		
		//����ϰ��   								Ա����						����
		context.write(new LongWritable(Long.parseLong(words[0])), new Text("*"+words[1]) );
		
		//���Ա����								�ϰ��					����
		try{
			context.write(new LongWritable(Long.parseLong(words[3])), new Text(words[1]));
		}catch(Exception ex){
			context.write(new LongWritable(-1), new Text(words[1]));
		}
		
	}
	

}
