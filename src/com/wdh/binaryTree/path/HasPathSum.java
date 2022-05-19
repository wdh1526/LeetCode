package com.wdh.binaryTree.path;

import com.wdh.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 17:21
 */
public class HasPathSum {
    public static void main(String[] args) {

    }

    public static boolean hasPathSumRecursion(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return root.getVal() == targetSum;
        }
        return hasPathSumRecursion(root.getLeft(), targetSum-root.getVal()) ||
                hasPathSumRecursion(root.getRight(), targetSum - root.getVal());
    }

    public static boolean hasPathSumIterate(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(root.getVal());
        while (!queue1.isEmpty()){
            root = queue1.remove();
            int tmpSum = queue2.remove();
            if(root.getLeft() == null && root.getRight() == null){
                if(tmpSum == targetSum){
                    return true;
                } else {
                    continue;
                }
            }
            if(null != root.getLeft()){
                queue1.add(root.getLeft());
                queue2.add(tmpSum+root.getLeft().getVal());
            }
            if(null != root.getRight()){
                queue1.add(root.getRight());
                queue2.add(tmpSum+root.getRight().getVal());
            }
        }
        return false;
    }
}
