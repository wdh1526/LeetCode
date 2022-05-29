package com.wdh.backtrack;

import java.util.*;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/22 01:18
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{3,3,0,3}));
    }

    private  List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums){
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, visited);
        return res;
    }

    private void  backtrack(List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i= 0; i< nums.length;i++){
            if(visited[i] || (i>0 && nums[i] == nums[i-1] && visited[i-1])){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(list,nums,visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
