package MRanl.revertedindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RevertedIndexCombiner extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text k21, Iterable<Text> v21, Context context)
			throws IOException, InterruptedException {
		// 对v21求和操作
		long total = 0 ;
		for(Text v : v21){
			total = total + Long.parseLong(v.toString());
		}
		
		//从k21中解析出文件名  love:data01.txt
		String str = k21.toString();
		
		//找到冒号的位置
		int index = str.indexOf(":");
		//单词和文件名分开
		String word = str.substring(0, index);
		String fileName = str.substring(index+1);
		
		//输出
		context.write(new Text(word), new Text(fileName+":"+total));
		
	}
	
	

}
