package com.wdh.heap;



import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/26 17:36
 */
public class KthNum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(kthNum(nums,2));
    }

    public static int kthNum(int[] nums, int k){
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(queue.size() > k){
                queue.remove();
            }
        }
        return queue.peek();
    }
}
