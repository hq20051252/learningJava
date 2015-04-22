package org.apache.hadoop.learn;

import java.io.UnsupportedEncodingException;

public class TestString {
	public static String[] testSplit(String ins){
		String[] v = ins.split(new String("."));
		return v;
	}
	public static void main(String[] args) {
		// TODO �Զ���ɵķ������
		//String v = "org.apache";
		//byte[] b = v.getBytes();
		//System.out.printf("the length of the string is %d.\n", v.length());
		//System.out.printf("the length of the byte array is %d.\n", b.length);
		//String[] va = v.split("\\.");
		//System.out.println(va[0]);
		//System.out.println("org.apache");
        String s = "大家好。";
        System.out.println(s);
        try {
            String tsg = new String(s.getBytes("gbk"), "gbk");
            System.out.println(tsg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String tsu = new String(s.getBytes("gbk"), "utf-8");
            System.out.println(tsu);
            String tsug = new String(tsu.getBytes("utf-8"), "gbk");
            System.out.println(tsug);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}

}
