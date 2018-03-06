package demo.rpc.server;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class MyRPCServer {

	public static void main(String[] args) throws Exception {
		// 创建一个hadoop的RPCserver 并把我们的程序部署上来
		RPC.Builder builder = new RPC.Builder(new Configuration());
		
		builder.setBindAddress("localhost");//设置server地址
		
		builder.setPort(7788);//设置server运行端口
		
		//将自己程序部署到rpc server上
		builder.setProtocol(MyBusiness.class);
		//将接口的实现部署上来
		builder.setInstance(new MyBusinessImpl());
		
		//通过builder创建一个rpc server
		Server server = builder.build();
		
		//启动server
		server.start();
	}

}
