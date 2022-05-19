package com.wdh.binaryTree.traverse;

import com.wdh.binaryTree.TreeNode;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 11:00
 */
public class BuildTreeFromPreAndIn {
    public static void main(String[] args) {
        build(new int[]{1,2}, new int[]{2,1});
    }

    public static TreeNode build(int[] preOrder, int[] inOrder){
        return helper(preOrder,inOrder,0, 0, inOrder.length-1);
    }

    private static TreeNode helper(int[] preOrder, int[] inOrder, int preStart, int inStart, int inEnd){
        if(preStart>=preOrder.length || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = 0;
        for (int i = 0; i < inEnd; i++) {
            if(inOrder[i] == preOrder[preStart]){
                index = i;
                break;
            }
        }
        root.setLeft(helper(preOrder,inOrder,preStart+1, inStart,index-1));
        root.setRight(helper(preOrder,inOrder,preStart+index- inStart +1 , index+1, inEnd));
        return root;
    }


}
