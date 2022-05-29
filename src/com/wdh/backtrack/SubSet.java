package com.wdh.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/24 09:46
 */
public class SubSet {
    public static void main(String[] args) {
        System.out.println(new SubSet().subSet(new int[]{1,2,3}));
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subSet(int[] nums){
        backtrack(nums,0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int cur, List<Integer> curList){
        res.add(new ArrayList<>(curList));
        for(int i = cur; i< nums.length;i++){
            curList.add(nums[i]);
            backtrack(nums,i+1, curList);
            curList.remove(curList.size()-1);
        }
    }
}
