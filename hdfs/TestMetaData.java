package demo;

import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class TestMetaData {
	
	
	//查看目录或文件信息
	@Test
	public void test1() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		FileSystem client = FileSystem.get(conf);
		
		//获取：/folder1 目录信息
		FileStatus[] fileStatus = client.listStatus(new Path("/folder1"));
		
		for(FileStatus s:fileStatus){
			//获取文件或者目录属性
			 System.out.println(s.isDirectory()?"目录":"文件");
			 System.out.println(s.getBlockSize());
			 System.out.println(s.getAccessTime());
			 System.out.println(s.getPath());
			 
		}
	}
	
	
	@Test
	public void test2() throws Exception{
		//获取某个文件在HDFS的位置
		
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		FileSystem client = FileSystem.get(conf);
		
		FileStatus filestatus = client.getFileStatus(new Path("/folder1/a.tar.gz"));
		
		//获取该文件对应数据块的地址信息
		BlockLocation[] locations = client.getFileBlockLocations(filestatus, 0, filestatus.getLen());
		
		for(BlockLocation blk : locations){
			//数据块的主机信息
			System.out.println(Arrays.toString(blk.getHosts()));
			
			//数据块名称
			System.out.println(Arrays.toString(blk.getNames()));
			
			
		}
		
		
	}
}
