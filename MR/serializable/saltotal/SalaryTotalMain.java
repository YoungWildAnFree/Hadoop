package MR.serializable.saltotal;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class  SalaryTotalMain{

	public static void main(String[] args) throws Exception {
		// // ����һ��job = mapper+reducer
		//Job job = new Job(new Configuration()); ���ַ�ʽ�����˲���Ҳ������
		Job job = Job.getInstance(new Configuration());
		
		//ָ����������
		job.setJarByClass(SalaryTotalMain.class);
		
		//ָ�������mapper�������������
		job.setMapperClass(SalaryTotalMapper.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Employee.class);
		
		//ָ�������Reducer�������������
		job.setReducerClass(SalaryTotalReducer.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(LongWritable.class);
		
		//ָ���������Ŀ¼
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//ִ������  true��ʾִ������ʱ��ӡ��־
		job.waitForCompletion(true);
	}

}
