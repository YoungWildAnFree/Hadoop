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
		//���ӵ�NameNode
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.157.111:9000");
		
		//�õ�HDFS�Ŀͻ���
		FileSystem client = FileSystem.get(conf);
		
		//�õ�һ�������� <--------HDFS:/folder1/a.tar.gz
		InputStream in = client.open(new Path("/folder1/a.tar.gz"));
		
		//����һ���������ָ�򱾵�Ŀ¼:  d:\\temp
		OutputStream out = new FileOutputStream("d:\\temp\\xyz.tar.gz");
		
		//����һ��������
		byte[] buffer = new byte[1024];
		//����
		int len = 0;
		while((len=in.read(buffer)) >0){
			//д���������
			out.write(buffer, 0, len);
		}
		
		out.flush();
		
		//�ر�
		in.close();
		out.close();
	}
	
	@Test
	public void test2() throws Exception{
		//���ӵ�NameNode
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.157.111:9000");
		
		//�õ�HDFS�Ŀͻ���
		FileSystem client = FileSystem.get(conf);
		
		//�õ�һ�������� <--------HDFS:/folder1/a.tar.gz
		InputStream in = client.open(new Path("/folder1/a.tar.gz"));
		
		//����һ���������ָ�򱾵�Ŀ¼:  d:\\temp
		OutputStream out = new FileOutputStream("d:\\temp\\abc.tar.gz");	
		
		//ʹ�ù������
		IOUtils.copyBytes(in, out, 1024);
	}
}





















