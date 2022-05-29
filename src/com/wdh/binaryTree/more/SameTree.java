package com.wdh.binaryTree.more;

import com.wdh.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 07:30
 */
public class SameTree {
    public static void main(String[] args) {
        System.out.println(isSameTreeIterate(new TreeNode(1,new TreeNode(2), new TreeNode(1)),
                new TreeNode(1,new TreeNode(1), new TreeNode(2))));
        System.out.println(isSameTreeRecursion(new TreeNode(1,new TreeNode(2), new TreeNode(1)),
                new TreeNode(1,new TreeNode(1), new TreeNode(2))));
        System.out.println(isSameTreeBFS(new TreeNode(1,new TreeNode(2), new TreeNode(1)),
                new TreeNode(1,new TreeNode(1), new TreeNode(2))));
    }

    public static boolean isSameTreeIterate(TreeNode p, TreeNode q){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while ((!stack1.empty() && !stack2.empty() || (p != null && q != null))){
            while (p != null && q != null){
                stack1.push(p);
                stack2.push(q);
                p = p.getLeft();
                q = q.getLeft();
            }
            if(p != null || q != null){
                return false;
            }
            p = stack1.pop();
            q = stack2.pop();
            if(p.getVal() != q.getVal()){
                return false;
            }
            p = p.getRight();
            q = q.getRight();
        }
        return p == null && q ==null && stack1.empty() && stack2.empty();
    }

    public static boolean isSameTreeRecursion(TreeNode p, TreeNode q){

        if(p == null || q == null){
            return p == q;
        }

        if(p.getVal() != q.getVal()){
            return false;
        }
        return isSameTreeRecursion(p.getLeft(),q.getLeft()) && isSameTreeRecursion(p.getRight(),q.getRight());
    }

    public static boolean isSameTreeBFS(TreeNode p, TreeNode q){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            p = queue1.remove();
            q = queue2.remove();
            if(p.getVal() != q.getVal()){
                return false;
            }
            if(p.getLeft() != null && q.getLeft() != null){
                queue1.add(p.getLeft());
                queue2.add(q.getLeft());
            }
            if(p.getLeft() == null ^ q.getLeft() == null){
                return false;
            }
            if(p.getRight() != null && q.getRight() != null){
                queue1.add(p.getRight());
                queue2.add(q.getRight());
            }
            if(p.getRight() == null ^ q.getRight() == null){
                return false;
            }
        }
        return (queue1.isEmpty() && queue2.isEmpty());
    }
}
