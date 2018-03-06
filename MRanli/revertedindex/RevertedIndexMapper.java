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
		//����  I love Beijing I love Shanghai  �ļ�data01.txt
		//�õ��ļ�·��  /myindex/data01.txt
		String path = ((FileSplit) context.getInputSplit()).getPath().toString();
		
		//�����ļ���  �õ����һ��б��
		int index = path.lastIndexOf("/");
		//�õ��ļ���
		String fileName = path.substring(index + 1);
		
		//��������
		String data = value1.toString();
		String[] words = data.split(" ");
		
		for(String w:words){
			context.write(new Text(w+":"+fileName), new Text("1"));
		}
	}
	

}
