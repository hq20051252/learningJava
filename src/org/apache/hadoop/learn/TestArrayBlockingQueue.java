package org.apache.hadoop.learn;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ��������
 * 
 * @author �ּ���
 * @version 1.0 2013-7-25 ����04:59:02
 */
public class TestArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(20);
        for (int i = 0; i < 30; i++) {
            // ��ָ��Ԫ����ӵ��˶����У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
            queue.put(i);
            System.out.println("�����������������Ԫ��:" + i);
        }
        System.out.println("���򵽴����н����������˳�----");
    }
}