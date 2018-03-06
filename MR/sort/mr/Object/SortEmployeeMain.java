package MR.sort.mr.Object;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class SortEmployeeMain {

	public static void main(String[] args) throws Exception {
		// // ����һ��job = mapper+reducer
		//Job job = new Job(new Configuration()); ���ַ�ʽ�����˲���Ҳ������
		Job job = Job.getInstance(new Configuration());
		
		//ָ����������
		job.setJarByClass(SortEmployeeMain.class);
		
		//ָ�������mapper�������������
		job.setMapperClass(SortEmployeeMapper.class);
		job.setOutputKeyClass(Employee.class);
		job.setOutputValueClass(NullWritable.class);
		
		//ָ�������Reducer�������������
		job.setReducerClass(SortEmployeeReducer.class);
		job.setOutputKeyClass(Employee.class);
		job.setOutputValueClass(NullWritable.class);
		
		//ָ���������Ŀ¼
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//ִ������  true��ʾִ������ʱ��ӡ��־
		job.waitForCompletion(true);

	}

}
