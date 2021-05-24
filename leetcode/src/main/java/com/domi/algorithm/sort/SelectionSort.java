package com.domi.algorithm.sort;

import java.util.Arrays;

/**
 * @author domisong.
 * @description: 选择排序
 * @date 2021/4/30.
 */
public class SelectionSort {


    /**
     *
     *
     * @description: 生成随机数组
     * @param maxSize 最大大小
     * @param maxValue 最大值
     * @return int[]
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() = [0,1)
        // (n + 1) * Math.random() = [0, n]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 这个数组范围: [-n, +n]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     *
     *
     * @description: 拷贝数组
     * @param arr 数组
     * @return int[]
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     *
     *
     * @description: 用自带的排序
     * @param arr 数组
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     *
     *
     * @description: 选择排序
     * @param arr 数组
     * @return int[]
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static  int[] selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        for(int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        return  arr;
    }

    /**
     *
     *
     * @description: 交换位置
     * @param arr 数组
     * @param i i
     * @param j j
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     *
     *
     * @description: 是否相等
     * @param arr1 数组1
     * @param arr2 数组2
     * @return boolean
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     *
     * @description: 打印数组
     * @param arr 数组
     * @author domisong.
     * @date: 2021/4/30.
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 测试次数
        int testTime = 500000;
        // 最大大小
        int maxSize = 100;
        // 最大值
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
           int[] arr1 = generateRandomArray(maxSize, maxValue);
           int[] arr2 = copyArray(arr1);

           // 选择排序
           selectionSort(arr1);
           // 本身的排序
           comparator(arr2);

           if (!isEqual(arr1, arr2)) {
               succeed = false;
               printArray(arr1);
               printArray(arr2);
               break;
           }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);

    }
}
