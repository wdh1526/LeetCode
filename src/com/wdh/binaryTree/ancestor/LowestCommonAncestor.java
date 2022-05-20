package com.wdh.binaryTree.ancestor;

import com.wdh.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 21:31
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    private static TreeNode res;

    private static Map<TreeNode,TreeNode> parent = new HashMap<>();

    private static Set<TreeNode> visited = new HashSet();

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        dfs(root,p,q);
        return res;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean lson = dfs(root.getLeft(), p, q);
        boolean rson = dfs(root.getRight(), p, q);
        if((lson && rson) || ((root.getVal() == p.getVal() || root.getVal() == q.getVal())
                &&(lson || rson))){
            res = root;
        }
        return lson && rson || (root.getVal() == p.getVal() || root.getVal() == q.getVal());
    }


    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        traverse(root);
        while (p != null){
            visited.add(p);
            p = parent.get(p);
        }
        while (q!=null){
            if(visited.contains(q)){
                return q;
            }
            q = parent.get(q);
        }
        return null;
    }

    private static void traverse(TreeNode root){
        if(root.getLeft() != null){
            parent.put(root.getLeft(), root);
            traverse(root.getLeft());
        }
        if(root.getRight() != null){
            parent.put(root.getRight(), root);
            traverse(root.getRight());
        }
    }

}
