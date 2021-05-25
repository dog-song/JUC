package com.domi.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Domi on 2020/12/16.
 */
public class T01 {

    /*************************************
     *      数组排序之选择排序
     *
     * 给你一个整数数组nums，请你将该数组升序排列。
     * 示例1：
     *     输入：nums = [5,2,3,1]
     *     输出：[1,2,3,5]
     *     示例 2：
     *
     *     输入：nums = [5,1,1,2,0,0]
     *     输出：[0,0,1,1,2,5]
     *
     * 要求：
     * 使用选择排序
     * 在时间复杂度，空间复杂度，是否为原地排序，是否具有稳定性给出答案。
     *
     ************************************/
    public static void main(String[] args) {

        int[] ints = new int[]{5,1,1,2,0,0};

        int[] sort = sort(ints);

        System.out.println(Arrays.toString(sort));
    }

    /************************************
     * 原地排序,是指不申请多余的空间来进行的排序，就是在原来的排序数据中比较和交换的排序
     * 属于原地排序的是:希尔排序、冒泡排序、插入排序、选择排序、堆排序、快速排序
     * 是原地 具有不稳定性
     * 时间复杂度 O(n^2) : 两层for循环 n * n
     * 空间复杂度 O(1) : 没有申请多余的空间
     *
     *  输入: 5 1 1 2 0 0
     *
     *  1> 0 1 1 2 5 0
     *  2> 0 0 1 2 5 1
     *  3> 0 0 1 2 5 1
     *  4> 0 0 1 1 5 2
     *  5> 0 0 1 1 2 5
     *
     *  输出: 0 0 1 1 2 5
     *
     ************************************/
    public static int[] sort(int[] list){

        for (int j = 0; j < list.length; j++){
            int minIndex = j;

            // 选择出最小的值，然后与首位交换，接下来的每个位置一样处理
            for (int i = j; i < list.length; i++){
                if (list[minIndex] > list[i]){
                    minIndex = i;
                }
            }
            // 交换顺序
            int valueOfMinIndex = list[j];
            list[j] = list[minIndex];
            list[minIndex] = valueOfMinIndex;
        }
        return list;
    }
}
