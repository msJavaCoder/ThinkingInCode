package cn.msjava.coding;

/**
 * @author msJava
 * @Description: 定义二叉树
 */
public class TreeNode {
     int data;
     TreeNode leftChild;
     TreeNode rightChild;

    public TreeNode() {
    }

    TreeNode(int data){
        this.data=data;
    }

    public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
