package se.algorithanalysis;

/***
 * 最大子序列求和问题
 */
public class MaxSubseqSumTest {

    public static int maxSubSum1(int[] a) {

        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j < a.length; j++) {

                int thisSum = 0;

                for (int k = i; k <= j; k++) {

                    thisSum += a[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    public static int maxSubSum2(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {

            int thisSum = 0;

            for (int j = i; j < a.length; j++) {

                thisSum += a[j];

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    public static int maxSubSum3(int[] a) {

        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
        }

        if(thisSum > maxSum){
            maxSum = thisSum;
        }else if(thisSum < 0){
            thisSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] a = {1, 3, 24, 12, -5, 43, 54, 2, 31, 344, 23};
        long start1 = System.currentTimeMillis();
        int result = maxSubSum1(a);
        System.out.println(result);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        int result2 = maxSubSum2(a);
        System.out.println(result2);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        long start3 = System.currentTimeMillis();
        int result3 = maxSubSum3(a);
        System.out.println(result3);
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);


    }

}
