package demo.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import demo.rpc.server.MyBusiness;

public class MyRPCClient {

	public static void main(String[] args) throws Exception {
		//����rpc �ͻ��� ����server�˹���
		//ͨ��rpc����server�˵Ĺ��� �õ�����һ���������
		
		MyBusiness Proxy = RPC.getProxy(MyBusiness.class,//�ڷ���������Ľӿ�
				MyBusiness.versionID,//�ڷ������˲����ID��
				new InetSocketAddress("localhost", 7788), //�������˵ĵ�ַ
				new Configuration());
		//ͨ��proxy�Ĵ������ȥ���÷������˹���
		System.out.println(Proxy.sayHello("Tom"));
	}

}
