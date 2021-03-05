package cn.msjava.coding;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author msJava
 * @Description: leetcode
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println((1+1)%7);
    }

    /**
     * 1768. 交替合并字符串
     * @param word1
     * @param word2
     * @return
     */
    public static String mergeAlternately(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        StringBuilder sb = new StringBuilder(len1+len2);
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            if(i<len1){
                sb.append(word1.charAt(i));
            }
            if(i<len2){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
       // 结点不为空才能入队
        if(root!=null){
            queue.offer(root);
        }
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        while (!queue.isEmpty()){
            // 当前层的元素个数
            final int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<Integer>();
            // 遍历当前层的每一个结点
            for (int i = 0; i < size; i++) {
                // 当前层的前面结点先出队
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                // 下一层的结点入队  只能非空才能入队
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            list.add(temp);
        }
        return list;
    }


}
