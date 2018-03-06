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
		// 创建一个job = mapper+reducer
		//Job job = new Job(new Configuration()); 这种方式过期了不过也可以用
		Job job = Job.getInstance(new Configuration());
		
		//指定任务的入口
		job.setJarByClass(AvgNumberMain.class);
		
		//指定任务的mapper和输出数据类型
		job.setMapperClass(AvgNumberMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
//		
//		//指定任务combiner combiner是一种特殊的reducer
//		job.setCombinerClass(AvgNumberReducer.class);
//		//对于求平均值问题  在mapper阶段先做一次合并的话  是错误的
//		
		
		
		//指定任务的Reducer和输出数据类型
		job.setReducerClass(AvgNumberReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		//指定输入输出目录
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//执行任务  true表示执行任务时打印日志
		job.waitForCompletion(true);
	}

}
