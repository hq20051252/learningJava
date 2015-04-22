package org.apache.hadoop.learn;

import java.util.regex.Pattern;

public class TestPattern {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] rs = Pattern.compile("\\.").split("org.apache");
		System.out.print(rs[0]);
	}

}
