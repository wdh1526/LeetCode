package com.wdh;

/**
 * @author wdh0713
 * @version 1.0
 * @date 2022/5/18 18:03
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;



    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode() {
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal(){
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
