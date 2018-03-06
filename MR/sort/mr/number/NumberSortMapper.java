package MR.sort.mr.number;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NumberSortMapper extends Mapper<LongWritable, Text, LongWritable, NullWritable> {

	@Override
	protected void map(LongWritable key1, Text value1,Context context)
			throws IOException, InterruptedException {
		// 
		String str = value1.toString();
		
		//��������ַ���ת�������� ��ΪK2���
		context.write(new LongWritable(Long.parseLong(str)), NullWritable.get());
	}
	

}
