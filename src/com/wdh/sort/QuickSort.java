package com.wdh.sort;

import java.util.Arrays;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/25 18:55
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,2,4,9,6,11,1};
        System.out.println("原数组："+ Arrays.toString(nums));
        sort(nums,0, nums.length-1);
        System.out.println("排序后："+ Arrays.toString(nums));
    }

    private static void sort(int[] nums,int lo, int hi){
        if (hi <= lo) return;
        int partition = partition(nums, lo, hi);
        sort(nums, lo, partition-1);
        sort(nums,partition+1, hi);
    }

    private static  int partition(int[] nums,int lo, int hi){
        int start = nums[lo];
        int i = lo, j = hi+1;
        while (true){
            while (nums[++i] < start){
                if(i==hi){
                    break;
                }
            }
            while (nums[--j] > start){
                if(j==lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
