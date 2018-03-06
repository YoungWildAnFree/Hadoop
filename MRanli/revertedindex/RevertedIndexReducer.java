package MRanl.revertedindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RevertedIndexReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text k3, Iterable<Text> v3,Context context)
			throws IOException, InterruptedException {
		//��V3�е�ÿ���ַ��� ƴ��
		
		String str = "";
		for(Text v:v3){
			str = str+"("+v.toString()+")";
		}
		
		context.write(k3, new Text(str));
	}

}
