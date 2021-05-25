package com.domi.algorithm.sort;

import java.util.Arrays;

/**
 * Created by Domi on 2020/12/17.
 */
public class T02 {
    /*************************************
     *      数组排序 之 归并排序
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
        int[] arr = {5,1,1,2,0,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
