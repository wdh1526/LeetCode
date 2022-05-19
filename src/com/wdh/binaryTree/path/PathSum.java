package com.wdh.binaryTree.path;

import apple.laf.JRSUIUtils;
import com.wdh.binaryTree.TreeNode;

import java.util.*;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 17:29
 */
public class PathSum {
    public static void main(String[] args) {

    }


    public static List<List<Integer>> pathSumDFS(TreeNode root, int targetSum){
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, targetSum,res,queue);
        return res;
    }

    private static void dfs(TreeNode root, int targetSum, List<List<Integer>> res, Deque<Integer> queue){
        if(root == null){
            return;
        }
        queue.add(root.getVal());
        targetSum -= root.getVal();
        if(root.getLeft() == null && root.getRight() == null && targetSum == 0){
            res.add(new ArrayList<>(queue));
        }
        dfs(root.getLeft(),targetSum,res,queue);
        dfs(root.getRight(),targetSum,res,queue);
        queue.removeLast();//左右孩子都处理完才可以删除当前节点
    }

    public static List<List<Integer>> pathSumBFS(TreeNode root, int targetSum){
        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode,TreeNode> map = new HashMap<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(root.getVal());
        map.put(root,null);
        while (!queue1.isEmpty()){
            root = queue1.remove();
            int tmpSum = queue2.remove();
            if(root.getLeft() == null && root.getRight() == null){
                if(tmpSum == targetSum){
                    addRes(root,res,map);
                }
                continue;
            }
            if(root.getLeft() != null){
                queue1.add(root.getLeft());
                queue2.add(root.getLeft().getVal()+targetSum);
                map.put(root.getLeft(),root);
            }
            if(root.getRight() != null){
                queue1.add(root.getRight());
                queue2.add(root.getRight().getVal()+targetSum);
                map.put(root.getRight(),root);
            }
        }
        return res;
    }

    private static void addRes(TreeNode root, List<List<Integer>> res, Map<TreeNode,TreeNode> map){
        List<Integer> path = new ArrayList<>();
        while (map.containsKey(root)){
            path.add(0, root.getVal());
            root = map.get(root);
        }
        res.add(path);
    }
}
