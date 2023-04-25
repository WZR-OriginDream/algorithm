package lqb;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/5 - 22:16
 * @Version:v1.0
 */
public class test2020 {
    /**
     * 2020
     */
    @Test
    public void testA() {
        // 加密后的字符
        String str = "EaFnjISplhFviDhwFbEjRjfIBBkRyY";

        char[] arr = str.toCharArray();

        // 原字符
        String s1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // 加密后的字符
        String s2 = "yxmdacikntjhqlgoufszpwbrevYXMDACIKNTJHQLGOUFSZPWBREV";

        // 遍历加密后的字符串
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            //通过indexOf()方法获取已知加密后的
            //arr数组中每个字符对应与s2字符川中的索引index
            int index = s2.indexOf(arr[i]);
            //通过s1字符串获得index索引所对应的字符
            //然后只用append()方法进行拼接。
            sb.append(s1.charAt(index));
        }

        // YeRikGSunlRzgDlvRwYkXkrGWWhXaA
        System.out.println(sb.toString());
    }


    @Test
    public void testB() throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = s.parse("1921-7-23");
        Date date2 = s.parse("2020-7-1");
        int a = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60));
        System.out.println(a);
    }

    @Test
    public void testC() {
        int n = 100;
        int min = 10000;
        int temp, ans = 0;
        for (int k = 1; k <= 100; k++) {
            if (n % k == 0) {
                temp = n / k + k;
            } else {
                temp = n / k + 1 + k;
            }

            if (min > temp) {
                min = temp;
                ans = k;
            }
        }
        System.out.println(ans);
    }

    @Test
    public void testD() {
        int[] a = new int[]
                {9090400,
                        8499400,
                        5926800,
                        8547000,
                        4958200,
                        4422600,
                        5751200,
                        4175600,
                        6309600,
                        5865200,
                        6604400,
                        4635000,
                        10663400,
                        8087200,
                        4554000};

    }

    @Test
    public void testE() {
        BigInteger[]f=new BigInteger[2051];
        f[1]=new BigInteger("1");
        f[2]=new BigInteger("1");
        for(int i=3;i<=2020;i++){
            f[i]=f[i-1].add(f[i-2]);

        }
        System.out.println(f[2020].gcd(f[520]));
    }

    static BigInteger fib(int n){
        if(n==1 || n==2) return new BigInteger("1");
        BigInteger f1=new BigInteger("1");
        BigInteger f2=new BigInteger("1");
        return fib(n-1).add(fib(n-2));
    }

//    static BigInteger gcd(BigInteger m, BigInteger n) {
//        return m.remainder(n) == new BigInteger("0") ? n : gcd(n, m.remainder(n));
//    }

//    static int lcm(int m, int n){
//        return m*n/gcd(m, n);
//    }

    @Test
    public void testF(){
        Scanner sc =new Scanner(System.in);
        String str = sc.next();
        char[] c =str.toCharArray();
        int big=0;
        int small=0;
        int num=0;
        for(int i=0;i<c.length;i++){
            if(c[i]>='A'&&c[i]<='Z')
                big++;
            else if(c[i]>='a'&&c[i]<='z')
                small++;
            else if(c[i]>='0'&&c[i]<='9')
                num++;

        }
        System.out.println(big);
        System.out.println(small);
        System.out.println(num);
    }
    
    @Test
    public void testG(){

    }

}
