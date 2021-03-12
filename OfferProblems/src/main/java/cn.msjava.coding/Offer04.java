package cn.msjava.coding;

/**
 * msJava
 *
 * @Description 剑指 Offer 04. 二维数组中的查找
 * @Date 2021-02-28
 */
public class Offer04 {


    public static void main(String[] args) {
      int[][] arr=new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        boolean b = findNumberIn2DArray_01(arr, 5);
        boolean c = findNumberIn2DArray_01(arr, 5);
        System.out.println(b);
        System.out.println(c);

    }


    /**
     * 暴力遍历
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray_01(int[][] matrix ,int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 行数
        int rows = matrix.length;
        //列数
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 线性查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray_02(int[][] matrix ,int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {  // 列下标减 1
                column--;
            } else {
                row++;   // 行下标加 1
            }
        }
        return false;
    }

}
