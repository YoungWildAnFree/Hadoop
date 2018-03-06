package demo.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import demo.rpc.server.MyBusiness;

public class MyRPCClient {

	public static void main(String[] args) throws Exception {
		//创建rpc 客户端 调用server端功能
		//通过rpc调用server端的功能 拿到的是一个代理对象
		
		MyBusiness Proxy = RPC.getProxy(MyBusiness.class,//在服务器部署的接口
				MyBusiness.versionID,//在服务器端部署的ID号
				new InetSocketAddress("localhost", 7788), //服务器端的地址
				new Configuration());
		//通过proxy的代理对象去调用服务器端功能
		System.out.println(Proxy.sayHello("Tom"));
	}

}
