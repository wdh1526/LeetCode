package com.wdh.sort;

import java.util.Arrays;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/26 18:36
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,2,4,9,6,11,1};
        System.out.println("原数组："+ Arrays.toString(nums));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println("排序后："+ Arrays.toString(nums));
    }

    private  void sort(int[] nums){
        int N = nums.length;

        //build heap
        for(int k = N/2-1; k>=0;k--){
            sink(nums, k, N);
        }

        //sort
        for (int i = N-1; i >0; i--) {
            swap(nums,0,i);
            N--;
            sink(nums,0,N);
        }
    }

    private void  sink(int[] nums, int k, int N){
        int left = 2*k+1, right = left+1;
        int maxIndex = k;
        if(left<N && nums[left] > nums[maxIndex]){
            maxIndex = left;
        }
        if(right<N && nums[right] > nums[maxIndex]){
            maxIndex = right;
        }
        if(maxIndex != k){
            swap(nums,k, maxIndex);
            sink(nums,maxIndex,N);
        }
//        while (2*k+2<N){
//            int j = 2*k+1;
//            if(j< N && nums[j]<nums[j+1]) j++;
//            if(nums[k] > nums[j]) break;
//            swap(nums,k,j);
//            k = j;
//        }
    }



    private void  swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }
}
