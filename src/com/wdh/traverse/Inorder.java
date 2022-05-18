package com.wdh.traverse;



import com.wdh.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 17:49
 */
public class Inorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(inOrderTraversalByIterate(root));
        System.out.println(inOrderTraversalByRecursion(root));
    }

    public static List<Integer> inOrderTraversalByRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private static void recursion(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        recursion(root.getLeft(), res);
        res.add(root.getVal());
        recursion(root.getRight(), res);
    }

    public static List<Integer> inOrderTraversalByIterate(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            res.add(cur.getVal());
            cur = cur.getRight();
        }
        return res;
    }
}
