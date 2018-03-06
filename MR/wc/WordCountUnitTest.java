
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
		//���û������winutils.exe������������		
		//System.setProperty("hadoop.home.dir", "d:\\hadoop-2.4.1");
		
		
		//����mapper
		//����һ��map����
		
		WordCountMapper mapper = new WordCountMapper();
		//����һ��mapper��driver
		MapDriver<LongWritable, Text, Text, LongWritable> driver = new MapDriver<>(mapper);
		
		//ָ��map����������
		driver.withInput(new LongWritable(1), new Text("I love Beijing"));
		
		//ָ��map���������k2 v2
		driver.withOutput(new Text("I"), new LongWritable(1))
			  .withOutput(new Text("love"),new LongWritable(1) )
			  .withOutput(new Text("Beijing"), new LongWritable(1));
		
		//ִ�е�Ԫ���ԶԱ����������ݺ�ʵ�����еĽ��
		driver.runTest();
	}
	
	@Test
	public void testReduce() throws Exception{
		//����reducer����
		
		WordCountReducer reduce = new WordCountReducer();
		
		ReduceDriver<Text, LongWritable, Text, LongWritable> driver = new ReduceDriver<>(reduce);
		
		//ָ��reducer��������  k3 v3����
		//����v3����
		List<LongWritable> v3 = new ArrayList<>();
		//��v3�����v2
		v3.add(new LongWritable(1));
		v3.add(new LongWritable(1));
		v3.add(new LongWritable(1));
		
		//ָ��reducer��������
		driver.withInput(new Text("Beijing"), v3); 
		
		//ָ�����������  ��Ϊ������V3�м�����3��
		driver.withOutput(new Text("Beijing"), new LongWritable(3));
		//ִ��
		driver.runTest();
		
	}
	
	@Test
	public void testJob() throws Exception{
		
//		��WordCountMapper��WordCountReducer��Ϊһ��job����
		//�������Զ���
		WordCountMapper mapper = new WordCountMapper();
		WordCountReducer reducer = new WordCountReducer();
		
		//����һ��driver
//		MapReduceDriver<K1, V1, K2, V2, K3, V3> ʵ����<K1, V1, K2, V2, K4, V4>
		MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable>
			driver = new MapReduceDriver<>(mapper,reducer);
		
		//ָ��mapper��������
		driver.withInput(new LongWritable(1), new Text("I love Beijing"))
			.withInput(new LongWritable(4), new Text("I love China"))
			.withInput(new LongWritable(2), new Text("Beijing is the capital of China"));
		
		//ָ��reducer���������  
//		driver.withOutput(new Text("I"), new LongWritable(2))
//			  .withOutput(new Text("love"),new LongWritable(2))
//			  .withOutput(new Text("Beijing"), new LongWritable(2))
//			  .withOutput(new Text("China"), new LongWritable(2))
//			  .withOutput(new Text("is"), new LongWritable(1))
//			  .withOutput(new Text("the"), new LongWritable(1))
//			  .withOutput(new Text("capital"), new LongWritable(1))
//			  .withOutput(new Text("of"), new LongWritable(1));
		
		//Ҫ���ǵ��м�����
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
