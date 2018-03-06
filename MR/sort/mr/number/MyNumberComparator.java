package MR.sort.mr.number;

import org.apache.hadoop.io.LongWritable;

//自己定义的比较器
public class MyNumberComparator extends LongWritable.Comparator {

	@Override
	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		// 降序
		return -super.compare(b1, s1, l1, b2, s2, l2);
	}
	
}