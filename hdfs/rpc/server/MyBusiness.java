package demo.rpc.server;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBusiness extends VersionedProtocol {
	
	//定义ID号
	//定义一个签名 通过这个ID 就能区分在客户端调用的时候 具体调用哪个实现
	//要求：名称必须叫versionID
	public static long versionID = 11;

	//定义自己的方法
	public String sayHello(String name);

}
