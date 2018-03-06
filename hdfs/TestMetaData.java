package demo;

import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class TestMetaData {
	
	
	//�鿴Ŀ¼���ļ���Ϣ
	@Test
	public void test1() throws Exception{
		
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		FileSystem client = FileSystem.get(conf);
		
		//��ȡ��/folder1 Ŀ¼��Ϣ
		FileStatus[] fileStatus = client.listStatus(new Path("/folder1"));
		
		for(FileStatus s:fileStatus){
			//��ȡ�ļ�����Ŀ¼����
			 System.out.println(s.isDirectory()?"Ŀ¼":"�ļ�");
			 System.out.println(s.getBlockSize());
			 System.out.println(s.getAccessTime());
			 System.out.println(s.getPath());
			 
		}
	}
	
	
	@Test
	public void test2() throws Exception{
		//��ȡĳ���ļ���HDFS��λ��
		
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.1:9000");
		
		FileSystem client = FileSystem.get(conf);
		
		FileStatus filestatus = client.getFileStatus(new Path("/folder1/a.tar.gz"));
		
		//��ȡ���ļ���Ӧ���ݿ�ĵ�ַ��Ϣ
		BlockLocation[] locations = client.getFileBlockLocations(filestatus, 0, filestatus.getLen());
		
		for(BlockLocation blk : locations){
			//���ݿ��������Ϣ
			System.out.println(Arrays.toString(blk.getHosts()));
			
			//���ݿ�����
			System.out.println(Arrays.toString(blk.getNames()));
			
			
		}
		
		
	}
}
