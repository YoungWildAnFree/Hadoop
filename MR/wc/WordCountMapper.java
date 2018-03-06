package MR.wc;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//public class WordCountMapper extends Mapper<k1, v1, k2, v2>{

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

	@Override
	protected void map(LongWritable key1, Text value1,Context context)
			throws IOException, InterruptedException {
		//context 表示mapper上下文 
		
		//得到HDFS读到的数据
		String str = value1.toString();
		//分词
		String[] words = str.split(" ");
		//输出到reduce 元组对 （Word，1）
		for(String w:words){
			context.write(new Text(w), new LongWritable(1));
		}
	}
	
	

}
