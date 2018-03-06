package demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

/*
 * ͨ��java API��HDFS�ϴ���Ŀ¼ mkdir����
 * ���⣺HDFSȨ������    windows���û� ȥ����hdfs   windows�µ��û��൱��linux�µ������û�   
 * �����
 * 1  System.setProperty("HADOOP_USER_NAME","root" );
 * 2  ͨ��java��-D�Ĳ��� ����HADOOP_USER_NAME 
 * 3  ͨ��chmod �����ļ�Ȩ��
 * 4  ��׵ķ�ʽ  ��hdfs-site �����ļ���dfs��permissions  ��Ϊfalse  ������hdfsȨ�޼�鹦��
 */


public class demo1 {
	@Test
	public void testMkdir1() throws Exception{
		//���û�������  ���û���Ϊroot
		System.setProperty("HADOOP_USER_NAME","root" );
		
	
		//���ӵ�NameNode��
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//�õ�hdfs�ͻ���
		FileSystem client  =  FileSystem.get(conf);
		
		//����Ŀ¼
		
		client.mkdirs(new Path("/folder1"));
	}
	
	
	//��java run as������ vm arguments -DHADOOP_USER_NAME=root
	@Test
	public void testMkdir2() throws Exception{
		
	
		//���ӵ�NameNode��
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//�õ�hdfs�ͻ���
		FileSystem client  =  FileSystem.get(conf);
		
		//����Ŀ¼
		
		client.mkdirs(new Path("/folder2"));
	}
}
