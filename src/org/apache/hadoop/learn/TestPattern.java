package org.apache.hadoop.learn;

import java.util.regex.Pattern;

public class TestPattern {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] rs = Pattern.compile("\\.").split("org.apache");
		System.out.print(rs[0]);
	}

}
