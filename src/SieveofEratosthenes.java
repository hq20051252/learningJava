import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SieveofEratosthenes {

    /**
     * 利用埃氏筛法求出limit内的素数
     * @param limit 寻找素数的上限
     * @return 返回一个整型数组，内容为limit范围内的素数
     */
    private static int[] sieveOfEratosthenes(int limit) {
        // 利用布尔数组标识数字是否保留
        boolean[] pos = new boolean[limit + 1];
        // 存放最后的结果
        int[] res = null;
        
        // i 是基数, 是一个素数, i 的倍数都是合数.
        int i = 2;
        // 标记出所有合数
        while(i*i <= limit) {
            // 标记出i的倍数, i是素数
            for(int m = 2;m*i <= limit; m++) {
                pos[m*i] = true;
            }
            // 找出i之后第一个标记为false的值， 这个数是素数,更新i
            for(int k = i+1; k <= limit; k++) {
                if(pos[k] == false) {
                    i = k;
                    break;
                }
            }
        }
        
        // 统计素数个数
        int num = 0;
        for(int k = 2; k <= limit; k++) {
            if(pos[k] == false) {
                num++;
            }
        }
        
        // 取出所有素数
        res = new int[num];
        for(int k = 2, j = 0;k <= limit; k++) {
            if(pos[k] == false) {
                res[j] = k;
                j++;
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        while(true) {
            System.out.println("请输入一个整数:");
            Scanner sc = new Scanner(System.in);
            int limit;
            try {
                limit = sc.nextInt();
                int[] primes = sieveOfEratosthenes(limit);
                System.out.println(limit + "以内的素数有: ");
                System.out.println(Arrays.toString(primes));
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
    }

}
