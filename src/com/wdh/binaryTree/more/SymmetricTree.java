package com.wdh.binaryTree.more;

import com.wdh.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 08:30
 */
public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println(isSymmetric(new TreeNode(1,new TreeNode(2), new TreeNode(3)),
                new TreeNode(1,new TreeNode(3), new TreeNode(2))));
        System.out.println(isSymmetric(new TreeNode(1,new TreeNode(2), new TreeNode(3)),
                new TreeNode(1,new TreeNode(2), new TreeNode(3))));
        System.out.println(isSymmetricIterate(new TreeNode(1,new TreeNode(2), new TreeNode(3)),
                new TreeNode(1,new TreeNode(3), new TreeNode(2))));
        System.out.println(isSymmetricIterate(new TreeNode(1,new TreeNode(2), new TreeNode(3)),
                new TreeNode(1,new TreeNode(2), new TreeNode(3))));
    }

    public static boolean isSymmetric(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        if(p.getVal() != q.getVal()){
            return false;
        }
        return isSymmetric(p.getLeft(),q.getRight()) && isSymmetric(p.getRight(), q.getLeft());
    }

    public static boolean isSymmetricIterate(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p = queue.remove();
            q = queue.remove();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.getVal() != q.getVal())) {
                return false;
            }

            queue.offer(p.getLeft());
            queue.offer(q.getRight());

            queue.offer(p.getRight());
            queue.offer(q.getLeft());
        }
        return true;
    }
}
