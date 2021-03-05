package cn.msjava.coding;

/**
 * @author msJava
 * @Description: 定义二叉树
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val){
        this.val=val;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
