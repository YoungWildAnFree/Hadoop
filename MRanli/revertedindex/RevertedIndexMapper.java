package MRanl.revertedindex;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

public class RevertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key1, Text value1, Context context)
			throws IOException, InterruptedException {
		//数据  I love Beijing I love Shanghai  文件data01.txt
		//得到文件路径  /myindex/data01.txt
		String path = ((FileSplit) context.getInputSplit()).getPath().toString();
		
		//解析文件名  得到最后一个斜线
		int index = path.lastIndexOf("/");
		//得到文件名
		String fileName = path.substring(index + 1);
		
		//处理数据
		String data = value1.toString();
		String[] words = data.split(" ");
		
		for(String w:words){
			context.write(new Text(w+":"+fileName), new Text("1"));
		}
	}
	

}
