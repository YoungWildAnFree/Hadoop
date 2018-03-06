package demo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class TestUploadFile {

	@Test
	public void test1() throws Exception{
		//连接NameNode
		Configuration  conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//得到HDFS客户端
		FileSystem client = FileSystem.get(conf);
		
		//创建一个输出流 指向HDFS
		OutputStream out =client.create(new Path("/folder1/a.tar.gz"));
		
		//创建输入流  
		InputStream in = new FileInputStream("d:\\temp\\....");
		
		//定义缓冲区 
		byte[] buffer = new byte[1024];
		
		//代表读入数据长度
		int len=0;
		while((len = in.read(buffer)) > 0){
			//读到了数据  就可以写到输出流中
			out.write(buffer, 0, len);
		}
		
		//刷新outputstream
		out.flush();
		
		//关闭io
		in.close();
		out.close();
	}
	
	
	@Test
	public void test2() throws Exception{
		//连接NameNode
		Configuration  conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//得到HDFS客户端
		FileSystem client = FileSystem.get(conf);
		
		//创建一个输出流 指向HDFS
		OutputStream out =client.create(new Path("/folder1/b.tar.gz"));
		
		//创建输入流   《----------d:\temp\。。。
		InputStream in = new FileInputStream("d:\\temp\\....");
		
		//使用hdfs工具类 来简化上传过程
		IOUtils.copyBytes(in, out, 1024);
	}
	
}
