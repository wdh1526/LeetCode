package com.wdh.sort;

import java.util.Arrays;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/25 18:30
 */
public class MergeSort {
    private static int[] arr;

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,2,4,9,6,11,1};
        arr = new int[nums.length];
        System.out.println("原数组："+ Arrays.toString(nums));
        sort(nums,0,nums.length-1);
        System.out.println("排序后："+ Arrays.toString(nums));
    }

    private static void sort(int[] nums, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int mid = lo+((hi-lo)>>>1);
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi){
        int i =lo, j = mid+1;
        for(int k = lo;k<=hi;k++){
            arr[k] = nums[k];
        }
        int index=lo;
        while (index <= hi){
            if(i>mid){
                nums[index++] = arr[j++];
            } else if(j > hi){
                nums[index++] = arr[i++];
            } else if(arr[i]<arr[j]){
                nums[index++] = arr[i++];
            } else {
                nums[index++] = arr[j++];
            }
        }
    }
}
