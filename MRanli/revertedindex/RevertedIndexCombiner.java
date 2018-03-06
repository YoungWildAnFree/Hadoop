package MRanl.revertedindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RevertedIndexCombiner extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text k21, Iterable<Text> v21, Context context)
			throws IOException, InterruptedException {
		// ��v21��Ͳ���
		long total = 0 ;
		for(Text v : v21){
			total = total + Long.parseLong(v.toString());
		}
		
		//��k21�н������ļ���  love:data01.txt
		String str = k21.toString();
		
		//�ҵ�ð�ŵ�λ��
		int index = str.indexOf(":");
		//���ʺ��ļ����ֿ�
		String word = str.substring(0, index);
		String fileName = str.substring(index+1);
		
		//���
		context.write(new Text(word), new Text(fileName+":"+total));
		
	}
	
	

}
