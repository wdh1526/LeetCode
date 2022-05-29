package com.wdh.binaryTree.traverse;

import com.wdh.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 20:19
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(postOrderTraversalByIterate(root));
        System.out.println(postOrderTraversalByRecursion(root));
    }

    public static List<Integer> postOrderTraversalByIterate(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode cur = stack.pop();
            res.add(0, cur.getVal());
            if(cur.getLeft() != null){
                stack.push(cur.getLeft());
            }
            if(cur.getRight() != null){
                stack.push(cur.getRight());
            }
        }
        return res;
    }


    public static List<Integer> postOrderTraversalByRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private static void recursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        recursion(root.getLeft(), res);
        recursion(root.getRight(),res);
        res.add(root.getVal());
    }
}
