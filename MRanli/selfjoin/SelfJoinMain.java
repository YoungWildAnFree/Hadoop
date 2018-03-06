package MRanli.selfjoin;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class SelfJoinMain {

	public static void main(String[] args) throws Exception {
		// ����һ��job = mapper+reducer
		//Job job = new Job(new Configuration()); ���ַ�ʽ�����˲���Ҳ������
		Job job = Job.getInstance(new Configuration());
		
		//ָ����������
		job.setJarByClass(SelfJoinMain.class);
		
		//ָ�������mapper�������������
		job.setMapperClass(SelfJoinMapper.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		
		
		//û��reducer ����mapper����������������
		job.setReducerClass(SelfJoinReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//ָ���������Ŀ¼
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//ִ������  true��ʾִ������ʱ��ӡ��־
		job.waitForCompletion(true);
	}

}
