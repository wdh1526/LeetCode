package com.wdh.binaryTree.traverse;

import com.wdh.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/29 11:26
 */
public class RightView {
    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList<>();

    private List<Integer> getRightView(TreeNode root){
        //层序
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int curSize = queue.size();
//            for (int i = 0; i < curSize; i++) {
//                root = queue.poll();
//                if(queue.size() == 0){
//                    res.add(root.getVal());
//                }
//                if(null != root.getLeft()){
//                    queue.offer(root.getLeft());
//                }
//                if(null != root.getRight()){
//                    queue.offer(root.getRight());
//                }
//            }
//        }
        dfs(root,0);
        return res;

    }

    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(depth == res.size()){
            res.add(root.getVal());
        }
        depth++;
        dfs(root.getRight(),depth);
        dfs(root.getLeft(),depth);
    }
}
