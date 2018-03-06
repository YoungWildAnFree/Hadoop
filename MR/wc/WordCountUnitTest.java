
package MR.wc;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;




public class WordCountUnitTest {
	
	@Test
	public void testMapper() throws Exception{
		//如果没有设置winutils.exe环境变量可以		
		//System.setProperty("hadoop.home.dir", "d:\\hadoop-2.4.1");
		
		
		//测试mapper
		//创建一个map对象
		
		WordCountMapper mapper = new WordCountMapper();
		//创建一个mapper的driver
		MapDriver<LongWritable, Text, Text, LongWritable> driver = new MapDriver<>(mapper);
		
		//指定map的输入数据
		driver.withInput(new LongWritable(1), new Text("I love Beijing"));
		
		//指定map输出的数据k2 v2
		driver.withOutput(new Text("I"), new LongWritable(1))
			  .withOutput(new Text("love"),new LongWritable(1) )
			  .withOutput(new Text("Beijing"), new LongWritable(1));
		
		//执行单元测试对比期望的数据和实际运行的结果
		driver.runTest();
	}
	
	@Test
	public void testReduce() throws Exception{
		//创建reducer对象
		
		WordCountReducer reduce = new WordCountReducer();
		
		ReduceDriver<Text, LongWritable, Text, LongWritable> driver = new ReduceDriver<>(reduce);
		
		//指定reducer输入数据  k3 v3集合
		//构造v3集合
		List<LongWritable> v3 = new ArrayList<>();
		//往v3中添加v2
		v3.add(new LongWritable(1));
		v3.add(new LongWritable(1));
		v3.add(new LongWritable(1));
		
		//指定reducer输入数据
		driver.withInput(new Text("Beijing"), v3); 
		
		//指定输出的数据  因为我们在V3中加入了3个
		driver.withOutput(new Text("Beijing"), new LongWritable(3));
		//执行
		driver.runTest();
		
	}
	
	@Test
	public void testJob() throws Exception{
		
//		把WordCountMapper和WordCountReducer作为一个job测试
		//创建测试对象
		WordCountMapper mapper = new WordCountMapper();
		WordCountReducer reducer = new WordCountReducer();
		
		//创建一个driver
//		MapReduceDriver<K1, V1, K2, V2, K3, V3> 实际是<K1, V1, K2, V2, K4, V4>
		MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable>
			driver = new MapReduceDriver<>(mapper,reducer);
		
		//指定mapper输入数据
		driver.withInput(new LongWritable(1), new Text("I love Beijing"))
			.withInput(new LongWritable(4), new Text("I love China"))
			.withInput(new LongWritable(2), new Text("Beijing is the capital of China"));
		
		//指定reducer的输出数据  
//		driver.withOutput(new Text("I"), new LongWritable(2))
//			  .withOutput(new Text("love"),new LongWritable(2))
//			  .withOutput(new Text("Beijing"), new LongWritable(2))
//			  .withOutput(new Text("China"), new LongWritable(2))
//			  .withOutput(new Text("is"), new LongWritable(1))
//			  .withOutput(new Text("the"), new LongWritable(1))
//			  .withOutput(new Text("capital"), new LongWritable(1))
//			  .withOutput(new Text("of"), new LongWritable(1));
		
		//要考虑到中间排序
		driver.withOutput(new Text("Beijing"), new LongWritable(2))
			  .withOutput(new Text("China"), new LongWritable(2))
			  .withOutput(new Text("I"), new LongWritable(2))
			  .withOutput(new Text("capital"), new LongWritable(1))
			  .withOutput(new Text("is"), new LongWritable(1))
			  .withOutput(new Text("love"),new LongWritable(2))
			  .withOutput(new Text("of"), new LongWritable(1))
			  .withOutput(new Text("the"), new LongWritable(1));
		
		
		driver.runTest();
		
	}

}
