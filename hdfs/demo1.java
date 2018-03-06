package demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

/*
 * 通过java API在HDFS上创建目录 mkdir操作
 * 问题：HDFS权限问题    windows的用户 去操作hdfs   windows下的用户相当于linux下的其他用户   
 * 解决：
 * 1  System.setProperty("HADOOP_USER_NAME","root" );
 * 2  通过java的-D的参数 设置HADOOP_USER_NAME 
 * 3  通过chmod 更改文件权限
 * 4  最彻底的方式  将hdfs-site 配置文件中dfs。permissions  改为false  禁用了hdfs权限检查功能
 */


public class demo1 {
	@Test
	public void testMkdir1() throws Exception{
		//设置环境变量  将用户改为root
		System.setProperty("HADOOP_USER_NAME","root" );
		
	
		//连接到NameNode上
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//得到hdfs客户端
		FileSystem client  =  FileSystem.get(conf);
		
		//创建目录
		
		client.mkdirs(new Path("/folder1"));
	}
	
	
	//在java run as中配置 vm arguments -DHADOOP_USER_NAME=root
	@Test
	public void testMkdir2() throws Exception{
		
	
		//连接到NameNode上
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		//得到hdfs客户端
		FileSystem client  =  FileSystem.get(conf);
		
		//创建目录
		
		client.mkdirs(new Path("/folder2"));
	}
}
