package demo;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class TestDownload {

	@Test
	public void test1() throws Exception{
		//连接到NameNode
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.157.111:9000");
		
		//得到HDFS的客户端
		FileSystem client = FileSystem.get(conf);
		
		//得到一个输入流 <--------HDFS:/folder1/a.tar.gz
		InputStream in = client.open(new Path("/folder1/a.tar.gz"));
		
		//创建一个输出流，指向本地目录:  d:\\temp
		OutputStream out = new FileOutputStream("d:\\temp\\xyz.tar.gz");
		
		//创建一个缓冲区
		byte[] buffer = new byte[1024];
		//长度
		int len = 0;
		while((len=in.read(buffer)) >0){
			//写到输出流中
			out.write(buffer, 0, len);
		}
		
		out.flush();
		
		//关闭
		in.close();
		out.close();
	}
	
	@Test
	public void test2() throws Exception{
		//连接到NameNode
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.157.111:9000");
		
		//得到HDFS的客户端
		FileSystem client = FileSystem.get(conf);
		
		//得到一个输入流 <--------HDFS:/folder1/a.tar.gz
		InputStream in = client.open(new Path("/folder1/a.tar.gz"));
		
		//创建一个输出流，指向本地目录:  d:\\temp
		OutputStream out = new FileOutputStream("d:\\temp\\abc.tar.gz");	
		
		//使用工具类简化
		IOUtils.copyBytes(in, out, 1024);
	}
}





















