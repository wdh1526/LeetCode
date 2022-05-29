package com.wdh.binaryTree.bst;

import com.wdh.TreeNode;

import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/20 10:40
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setRight(new TreeNode(6));
        root.setLeft(new TreeNode(3));
        TreeNode tmp =  root.getLeft();
        tmp.setLeft(new TreeNode(2));
        tmp.setRight(new TreeNode(4));
        tmp = tmp.getLeft();
        tmp.setLeft(new TreeNode(1));
        System.out.println(kthSmallest(root,3));
    }

    public static int kthSmallest(TreeNode root, int k){
        if(root == null){
            return 0;
        }
        int num = getNumOfLeft(root);
        if(num < k-1){
            return kthSmallest(root.getRight(),k-num-1);
        } else if(num == k-1){
            return root.getVal();
        } else {
            return kthSmallest(root.getLeft(),k);
        }
    }

    private static int getNumOfLeft(TreeNode root){
        if(root == null || root.getLeft() == null){
            return 0;
        }
        int num = 0;
        root = root.getLeft();
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            num++;
            root = root.getRight();
        }
        return num;
    }
}
