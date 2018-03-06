package demo.rpc.server;

import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;

public class MyBusinessImpl implements MyBusiness {

	@Override
	public String sayHello(String name) {
		// 
		System.out.println("�������˱�����");
		return "Hello "+name;
	}

	@Override
	public ProtocolSignature getProtocolSignature(String arg0, long arg1, int arg2) throws IOException {
		//ͨ��ID����һ��ǩ��
		
		return new ProtocolSignature(MyBusiness.versionID, null);
	}

	@Override
	public long getProtocolVersion(String arg0, long arg1) throws IOException {
		// ֱ�ӷ���ID��
		return MyBusiness.versionID;
	}

}
