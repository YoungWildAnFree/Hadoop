package MR.wrongcombiner;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class AvgNumberMain {

	public static void main(String[] args) throws Exception {
		// ����һ��job = mapper+reducer
		//Job job = new Job(new Configuration()); ���ַ�ʽ�����˲���Ҳ������
		Job job = Job.getInstance(new Configuration());
		
		//ָ����������
		job.setJarByClass(AvgNumberMain.class);
		
		//ָ�������mapper�������������
		job.setMapperClass(AvgNumberMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
//		
//		//ָ������combiner combiner��һ�������reducer
//		job.setCombinerClass(AvgNumberReducer.class);
//		//������ƽ��ֵ����  ��mapper�׶�����һ�κϲ��Ļ�  �Ǵ����
//		
		
		
		//ָ�������Reducer�������������
		job.setReducerClass(AvgNumberReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		//ָ���������Ŀ¼
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//ִ������  true��ʾִ������ʱ��ӡ��־
		job.waitForCompletion(true);
	}

}
