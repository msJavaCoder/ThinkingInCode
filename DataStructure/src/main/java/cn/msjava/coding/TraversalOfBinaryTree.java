package cn.msjava.coding;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author msJava
 * @Description: 二叉树遍历
 * 前序遍历   根 左 右
 * 中序遍历   左 根 右
 * 后序遍历   左 右 根
 */
public class TraversalOfBinaryTree {

    /**
     * 构建二叉树
     *
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }


    /**
     * 二叉树前序遍历
     *
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     *
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.leftChild);
        System.out.print(node.data);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
        System.out.print(node.data);
    }

    /**
     * 二叉树层次遍历
     * @param root
     */
    public static List<LinkedList<Integer>> levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null){
            queue.offer(root);
        }
        List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        while (!queue.isEmpty()){
            final int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.leftChild!=null){
                    queue.offer(cur.leftChild);
                }
                if(cur.rightChild!=null){
                    queue.offer(cur.rightChild);
                }
            }
            result.add(temp);
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null,4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历: ");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历: ");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历: ");
        postOrderTraveral(treeNode);
    }


}
