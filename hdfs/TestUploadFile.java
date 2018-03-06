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
		//����NameNode
		Configuration  conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//�õ�HDFS�ͻ���
		FileSystem client = FileSystem.get(conf);
		
		//����һ������� ָ��HDFS
		OutputStream out =client.create(new Path("/folder1/a.tar.gz"));
		
		//����������  
		InputStream in = new FileInputStream("d:\\temp\\....");
		
		//���建���� 
		byte[] buffer = new byte[1024];
		
		//����������ݳ���
		int len=0;
		while((len = in.read(buffer)) > 0){
			//����������  �Ϳ���д���������
			out.write(buffer, 0, len);
		}
		
		//ˢ��outputstream
		out.flush();
		
		//�ر�io
		in.close();
		out.close();
	}
	
	
	@Test
	public void test2() throws Exception{
		//����NameNode
		Configuration  conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//�õ�HDFS�ͻ���
		FileSystem client = FileSystem.get(conf);
		
		//����һ������� ָ��HDFS
		OutputStream out =client.create(new Path("/folder1/b.tar.gz"));
		
		//����������   ��----------d:\temp\������
		InputStream in = new FileInputStream("d:\\temp\\....");
		
		//ʹ��hdfs������ �����ϴ�����
		IOUtils.copyBytes(in, out, 1024);
	}
	
}
