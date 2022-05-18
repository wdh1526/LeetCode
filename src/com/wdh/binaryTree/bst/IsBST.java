package com.wdh.binaryTree.bst;

import com.wdh.binaryTree.TreeNode;

import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 20:55
 */
public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(1), new TreeNode(1));
        System.out.println(isBST(root));
        System.out.println(isBSTByInOrder(root));
    }

    public static boolean isBST(TreeNode root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode root, int lower, int higher){
        if(root == null){
            return true;
        }
        if(root.getVal() <= lower || root.getVal() >= higher){
            return false;
        }
        return isBST(root.getLeft(), lower, root.getVal()) && isBST(root.getRight(), root.getVal(),higher);
    }

    public static boolean isBSTByInOrder(TreeNode root){
        if(root == null){
            return true;
        }
        double pre = -Double.MAX_VALUE;
        int cur = root.getVal();;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.empty()){
            while (tmp != null){
                stack.push(tmp);
                tmp = tmp.getLeft();
            }
            tmp = stack.pop();
            if(tmp.getVal() <= pre){
                return false;
            }
            pre = tmp.getVal();;
            tmp = tmp.getRight();
        }
        return true;
    }
}
