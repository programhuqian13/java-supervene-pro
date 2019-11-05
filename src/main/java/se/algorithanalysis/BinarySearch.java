package se.algorithanalysis;

import java.util.Collection;

/**
 * @Description 折半查找
 * @Version 1.0
 * @Date 2019/10/21
 * @ProjectName java-supervene-pro
 * @PackageName se.algorithanalysis
 */
public class BinarySearch {

    public static final int NOT_FOUNT = -1;

    /***
     * 折半查找
     * @param a 待查找的数据列表 （列表需要进行排序）
     * @param x 查找的数据
     * @param <AnyType>
     * @return
     */
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType [] a,AnyType x){
        int low = 0,high = a.length -1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(a[mid].compareTo(x) < 0){
                high = mid + 1;
            }else if(a[mid].compareTo(x) > 0){
                low = mid - 1;
            }else{
                return mid;
            }
        }

        return NOT_FOUNT;
    }

    /***
     * 欧几里得算法-最大公因数
     * @return
     */
    public static long gcd(long m,long n){
        while(n != 0){
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     * 幂运算
     * @param x 求幂因子
     * @param n 幂数
     * @return
     */
    public static long pow(long x,int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        //如果是偶数
        if(isEven(n)){
            return pow(x * x ,n / 2);
        }else{
            return pow(x * x ,n / 2) * x;
        }
    }

    /**
     * 检查是否为偶数
     * @param n
     * @return
     */
    private static boolean isEven(int n) {

        if(n % 2 == 0){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Integer [] a = {64,32,16,8,5,3,2,0,-1};
        System.out.println(binarySearch(a,2));

        System.out.println(gcd(1989,1590));

        System.out.println(pow(5,4));
    }

}
