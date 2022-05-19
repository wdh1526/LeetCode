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

    public static List<List<Integer>> levelOrderTraversalByIterate(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList();
            int currentLevelSize = queue.size();
            for(int i=0; i< currentLevelSize; i++){
                root = queue.remove();
                currentLevel.add(root.getVal());
                if(root.getLeft() != null){
                    queue.add(root.getLeft());
                }
                if(root.getRight() != null){
                    queue.add(root.getRight());
                }
            }
            res.add(currentLevel);
        }
        return res;
    }
}
