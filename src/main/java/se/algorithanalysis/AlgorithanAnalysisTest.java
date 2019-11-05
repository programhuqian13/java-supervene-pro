package se.algorithanalysis;


import java.util.ArrayList;

/***
 * 算法的一般法则
 */
public class AlgorithanAnalysisTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = factorial(40);
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println("所耗费时间：" + (end - start));

        long start1 = System.currentTimeMillis();
        long result2 = fib(40);
        System.out.println(result2);
        long end1 = System.currentTimeMillis();
        System.out.println("所耗费时间：" + (end1 - start1));

    }


    public static long factorial(int n){

        if(n <= 1){
            return 1;
        }else{
            return n * factorial(n - 1);
        }

    }

    public static long fib(int n){
        if(n <=1){
            return 1;
        }else{
            return fib(n -1) + fib(n - 2);   //会违背合成效益法则，会将之前的操作的值重新操作一次
        }
    }

}
