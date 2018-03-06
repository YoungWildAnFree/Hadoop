package demo.rpc.server;

import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;

public class MyBusinessImpl implements MyBusiness {

	@Override
	public String sayHello(String name) {
		// 
		System.out.println("服务器端被调用");
		return "Hello "+name;
	}

	@Override
	public ProtocolSignature getProtocolSignature(String arg0, long arg1, int arg2) throws IOException {
		//通过ID构造一个签名
		
		return new ProtocolSignature(MyBusiness.versionID, null);
	}

	@Override
	public long getProtocolVersion(String arg0, long arg1) throws IOException {
		// 直接返回ID号
		return MyBusiness.versionID;
	}

}
