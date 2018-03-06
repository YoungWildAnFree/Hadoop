package MRanli.multitable;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MultitableReduer extends Reducer<LongWritable, Text, Text, Text> {

	@Override
	protected void reduce(LongWritable k3, Iterable<Text> v3, Context context)
			throws IOException, InterruptedException {
		// v3�п����ǲ������� Ҳ������Ա������
		String dname = "";
		String enameList ="";
		
		//��v3��ȡ���ַ��� 
		for(Text v:v3){
			
			String str = v.toString();
			
			//�ж��Ƿ���*��
			int flag = str.indexOf("*");
			
			if(flag <0 ){
				//û��*�� ����Ա������
				enameList =str+";"+enameList;
			}else{
				//�������� ȥ��*
				dname = str.substring(1);
			}
			
		}
		
		
		// ���  			��������           		һ�����ŵ�����Ա��
		context.write(new Text(dname), new Text(enameList));
	}
	

}
