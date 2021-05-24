package com.domi.algorithm.bit_operation;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/5/12.
 */
public class EorOperation {

    /**
     *  arr中，只有一种数，出现奇数次
     *
     * @description: 出现奇数次
     * @param arr 数组
     * @author domisong.
     * @date: 2021/5/12.
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }


    /**
     *  arr中，只有两种数，出现奇数次
     *
     * @description: 出现奇数次
     * @param arr 数组
     * @author domisong.
     * @date: 2021/5/12.
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        /*

        eor = a ^ b;
        eor != 0;
        eor 必然有一个位置上是1；
        0110 1000
        0000 1000

         */

        // 提取出最右的1
        int rightOne = eor & (~eor + 1);

        // eor'
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum2(arr2);


        // 二进制求加法：average = （a&b） + ((a^b)>>1) ;
        add(a, b);
        int add = Add(a, b);
        System.out.println(add);
    }


    public static void add(int a, int b) {
        int i = a ^ b;
        int j = (a & b) << 1;
        while (j > 0) {
            a = i ^ j;
            b = (i & j) << 1;
            i = a;
            j = b;
        }
        System.out.println(i);
    }


    public static int Add(int num1,int num2) {
        /*
         *  5+3   5^3(0110)   5&3(0001)
         *  0101
         *  0011
         */
        int a = num1 ^ num2;
        int b = num1 & num2;
        b = b << 1;
        if(b == 0) {
            return a;
        } else {
            return Add(a, b);
        }
    }
}
