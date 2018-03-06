package MRanli.selfjoin;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SelfJoinReducer extends Reducer<LongWritable, Text, Text, Text> {

	@Override
	protected void reduce(LongWritable k3, Iterable<Text> v3, Context context)
			throws IOException, InterruptedException {
		
		String bname = "";
		String enameList ="";
		
		for(Text v : v3){
			
			String str = v.toString();
			
			if(str.indexOf("*") < 0){
				enameList = enameList+str+";";
			}else{
				bname = str.substring(1);
			}
		}
		
		
		//��� ֻ����н��������   �п���Ա��û������  	��Boss�Ļ�û���ϰ�
		
		if(bname.length() > 0  && enameList.length() >0){
			context.write(new Text(bname), new Text("("+enameList+")"));
		}
	}
	

}
