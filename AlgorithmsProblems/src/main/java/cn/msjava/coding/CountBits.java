package cn.msjava.coding;

/**
 * @author msJava
 * @Description: leetcode 338. 比特位计数   动态规划
 *
 *    暴力   
 *
 *
 */
public class CountBits {
    public static int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            String string = Integer.toBinaryString(i);
            int count = count(string);
            arr[i] = count;
        }

        return arr;
    }

    /**
     * 计算字符串数字串  1 的个数
     * @param s
     * @return
     */
    private static int count(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
