package MR.sort.mr.String;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class StringSortMain {

	public static void main(String[] args) throws Exception {
		// ����һ��job = mapper+reducer
				//Job job = new Job(new Configuration()); ���ַ�ʽ�����˲���Ҳ������
				Job job = Job.getInstance(new Configuration());
				
				//ָ����������
				job.setJarByClass(StringSortMain.class);
				
				//ָ�������mapper�������������
				job.setMapperClass(StringSortMapper.class);
				job.setOutputKeyClass(Text.class);
				job.setOutputValueClass(NullWritable.class);
				
				
				//ָ���Լ��ıȽ���
				job.setSortComparatorClass(MyStringComparator.class);
				
				//û��reducer ����mapper����������������
				job.setOutputKeyClass(Text.class);
				job.setOutputValueClass(NullWritable.class);
				
				//ָ���������Ŀ¼
				FileInputFormat.setInputPaths(job, new Path(args[0]));
				FileOutputFormat.setOutputPath(job, new Path(args[1]));
				
				//ִ������  true��ʾִ������ʱ��ӡ��־
				job.waitForCompletion(true);

	}

}
