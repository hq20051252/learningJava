package org.apache.hadoop.learn;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TestLogicalOperator {

	public static void main(String[] args) throws Throwable{
		// TODO 自动生成的方法存根
        Calendar a = Calendar.getInstance();
        DateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date b = c.parse("2014-02-12 07:32:21");
        long v = Date.parse("2014-02-12 07:32:21");
        System.out.printf("Time is %s.\n", b.getTime());
        System.out.printf("Time is %s.\n", v);
	}

}
