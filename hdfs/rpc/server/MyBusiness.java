package demo.rpc.server;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBusiness extends VersionedProtocol {
	
	//����ID��
	//����һ��ǩ�� ͨ�����ID ���������ڿͻ��˵��õ�ʱ�� ��������ĸ�ʵ��
	//Ҫ�����Ʊ����versionID
	public static long versionID = 11;

	//�����Լ��ķ���
	public String sayHello(String name);

}
