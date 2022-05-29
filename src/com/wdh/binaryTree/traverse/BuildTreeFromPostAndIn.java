package com.wdh.binaryTree.traverse;

import com.wdh.TreeNode;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 11:44
 */
public class BuildTreeFromPostAndIn {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inOrder, int[] postOrder){
        return helper(inOrder, postOrder, postOrder.length-1, 0, inOrder.length-1);
    }

    private static TreeNode helper(int[] inOrder, int[] postOrder, int postEnd, int inStart, int inEnd){
        if(inStart > inEnd || postEnd <0){
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int index = -1;
        for(int i = inStart;i<= inEnd ;i++){
            if(inOrder[i] == root.getVal()){
                index = i;
                break;
            }
        }
        root.setRight(helper(inOrder,postOrder, postEnd-1, index+1, inEnd));
        root.setLeft(helper(inOrder,postOrder, postEnd-(inEnd-index)-1, inStart, index-1));
        return root;
    }
}
