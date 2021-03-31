package cn.msjava.coding.simple;


import cn.msjava.coding.TreeNode;

import java.util.HashMap;

/**
 * msJava
 *
 * @Description  剑指 Offer 07. 重建二叉树
 * @Date 2021-03-10
 */
public class Offer07 {

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();

    /**
     *
     * @param preorder   前序遍历
     * @param inorder    中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        // 递归终止
        if(left > right) {
            return null;
        }
        // 建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 划分根节点、左子树、右子树
        int i = dic.get(preorder[root]);
        // 开启左子树递归
        node.left = recur(root + 1, left, i - 1);
        // 开启右子树递归
        node.right = recur(root + i - left + 1, i + 1, right);
        // 回溯返回根节点
        return node;
    }

}
