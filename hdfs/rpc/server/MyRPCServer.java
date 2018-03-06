package demo.rpc.server;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class MyRPCServer {

	public static void main(String[] args) throws Exception {
		// ����һ��hadoop��RPCserver �������ǵĳ���������
		RPC.Builder builder = new RPC.Builder(new Configuration());
		
		builder.setBindAddress("localhost");//����server��ַ
		
		builder.setPort(7788);//����server���ж˿�
		
		//���Լ�������rpc server��
		builder.setProtocol(MyBusiness.class);
		//���ӿڵ�ʵ�ֲ�������
		builder.setInstance(new MyBusinessImpl());
		
		//ͨ��builder����һ��rpc server
		Server server = builder.build();
		
		//����server
		server.start();
	}

}
