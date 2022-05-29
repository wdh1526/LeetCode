package com.wdh.backtrack;

import java.util.*;


/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/21 19:15
 */
public class Combination {

    public static void main(String[] args) {
        Combination c = new Combination();
        System.out.println(c.combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }


    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        //backtrack(path,candidates,target,0);
        backtrack(candidates, target, 0, path);
        return res;
    }

    //不可重复使用
    private void backtrack(int[] candidates, int target, int cur, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i= cur;i<candidates.length;i++){
            if(i>cur && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target - candidates[i] >=0){
                list.add(candidates[i]);
                backtrack(candidates, target-candidates[i], i +1, list);
                list.remove(list.size()-1);
            } else {
                break;
            }
        }
    }

    //数字可重复使用
    private void backtrack(List<Integer> path,int[] candidates,int target,int begin) {
        if(0 == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            if(0 <= target-candidates[i]) {
                path.add(candidates[i]);
                backtrack(path,candidates,target - candidates[i],i);
                path.remove(path.size()-1);
            } else {
                break;
            }
        }
    }
}
