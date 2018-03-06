package MR.serializable.saltotal;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class  SalaryTotalMain{

	public static void main(String[] args) throws Exception {
		// // 创建一个job = mapper+reducer
		//Job job = new Job(new Configuration()); 这种方式过期了不过也可以用
		Job job = Job.getInstance(new Configuration());
		
		//指定任务的入口
		job.setJarByClass(SalaryTotalMain.class);
		
		//指定任务的mapper和输出数据类型
		job.setMapperClass(SalaryTotalMapper.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Employee.class);
		
		//指定任务的Reducer和输出数据类型
		job.setReducerClass(SalaryTotalReducer.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(LongWritable.class);
		
		//指定输入输出目录
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//执行任务  true表示执行任务时打印日志
		job.waitForCompletion(true);
	}

}
