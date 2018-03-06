package MRanl.revertedindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RevertedIndexReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text k3, Iterable<Text> v3,Context context)
			throws IOException, InterruptedException {
		//将V3中的每个字符串 拼接
		
		String str = "";
		for(Text v:v3){
			str = str+"("+v.toString()+")";
		}
		
		context.write(k3, new Text(str));
	}

}
