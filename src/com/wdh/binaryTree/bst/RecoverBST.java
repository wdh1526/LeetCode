package com.wdh.binaryTree.bst;

import com.wdh.TreeNode;

import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 22:03
 */
public class RecoverBST {
    public static void main(String[] args) {

    }

    public static void recover(TreeNode root){
        TreeNode first = null, second = null, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            if(pre != null && pre.getVal() > root.getVal()){
                second = root;
                if(first == null){
                    first = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.getRight();
        }
        swap(first,second);
    }

    private static void swap(TreeNode first, TreeNode second){
        int tmp = first.getVal();
        first.setVal(second.getVal());
        second.setVal(tmp);
    }
}
