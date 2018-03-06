package MRanli.multitable;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MultitableMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

	@Override
	protected void map(LongWritable key1, Text value1,Context context)
			throws IOException, InterruptedException {
		//�õ�����
		String data = value1.toString();
		
		//�ִ�
		String[] words = data.split(",");
		
		//�ж����鳤��
		if(words.length==3){
			//��ȡ�Ĳ�������
			//������źźͲ�������
			context.write(new LongWritable(Long.parseLong(words[0])), new Text("*"+words[1]));
		}else{
			
			//��ȡԱ������
			//���Ա������ �� Ա������
			context.write(new LongWritable(Long.parseLong(words[7])), new Text(words[1]));
		}
	
	}
	

}
