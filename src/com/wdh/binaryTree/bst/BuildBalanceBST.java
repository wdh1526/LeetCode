package com.wdh.binaryTree.bst;

import com.wdh.TreeNode;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/19 15:49
 */
public class BuildBalanceBST {
    public static void main(String[] args) {

    }

    public static TreeNode build(int[] nums){
        return helper(nums,0,nums.length-1);
    }

    private static  TreeNode helper(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.setLeft(helper(nums,start,mid-1));
        root.setRight(helper(nums,mid+1, end));
        return root;
    }
}
