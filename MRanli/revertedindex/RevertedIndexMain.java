package MRanl.revertedindex;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RevertedIndexMain {

	public static void main(String[] args) throws Exception {
		// 创建一个job = mapper+reducer
		//Job job = new Job(new Configuration()); 这种方式过期了不过也可以用
		Job job = Job.getInstance(new Configuration());
		
		//指定任务的入口
		job.setJarByClass(RevertedIndexMain.class);
		
		//指定任务的mapper和输出数据类型
		job.setMapperClass(RevertedIndexMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		
		//指定combiner
		job.setCombinerClass(RevertedIndexCombiner.class);
		
		//没有reducer 所以mapper的输出就是最终输出
		job.setReducerClass(RevertedIndexReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//指定输入输出目录
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//执行任务  true表示执行任务时打印日志
		job.waitForCompletion(true);
	}

}
