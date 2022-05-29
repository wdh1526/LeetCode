package com.wdh.twoPoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/27 09:18
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        //System.out.println(threeSum.threeSumClosest(new int[]{0,1,2}, 0));
        System.out.println(threeSum.threeSumClosest(new int[]{0,2,1,-3}, 1));
    }

    private int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE/2;
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1, right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target){
                    return target;
                }
                if(Math.abs(res-target) > Math.abs(sum-target)){
                    res= sum;
                }
                if (sum > target){
                    right--;
                    while (left<right && nums[right] == nums[right+1]){
                        right--;
                    }
                } else {
                    left++;
                    while (left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
