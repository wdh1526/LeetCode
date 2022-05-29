package com.wdh.binaryTree.traverse;

import com.wdh.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 20:17
 */
public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(preOrderTraversalByIterate(root));
        System.out.println(preOrderTraversalByRecursion(root));
    }

    public static List<Integer> preOrderTraversalByIterate(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res  = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode cur = stack.pop();
            res.add(cur.getVal());
            if(cur.getRight() != null){
                stack.push(cur.getRight());
            }
            if(cur.getLeft() != null){
                stack.push(cur.getLeft());
            }
        }
        return res;
    }


    public static List<Integer> preOrderTraversalByRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private static void recursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.getVal());
        recursion(root.getLeft(),res);
        recursion(root.getRight(),res);
    }
}
