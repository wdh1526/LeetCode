package com.wdh.binaryTree.traverse;

import com.wdh.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 20:41
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(levelOrderTraversalByIterate(root));
    }

    public static List<Integer> levelOrderTraversalByIterate(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            res.add(cur.getVal());
            if(cur.getLeft() != null){
                queue.add(cur.getLeft());
            }
            if(cur.getRight() != null){
                queue.add(cur.getRight());
            }
        }
        return res;
    }
}
