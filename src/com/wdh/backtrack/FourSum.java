package com.wdh.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/21 18:00
 */
public class FourSum {

    List<List<Integer>> res = new ArrayList();

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        int[] nums = new int[]{1,0,-1,0,-2,2};
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(fourSum.fourSum(nums,0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> curList = new ArrayList();
        Arrays.sort(nums);
        backtrack(0,curList, nums, target);
        return res;
    }

    private void backtrack(int cur, List<Integer> curList, int[] nums, int target){
        if(curList.size() == 3){
            if(0 == target){
                res.add(new ArrayList(curList));
            }
            return;
        }
        for(int i= cur; i< nums.length; i++){
            if(i>cur && nums[i] == nums[i-1]){
                continue;
            }
            if(target - nums[i]>=0) {
                curList.add(nums[i]);
                backtrack(i+1, curList, nums, target-nums[i]);
                curList.remove(curList.size()-1);
            } else {
                break;
            }
        }
    }
}
