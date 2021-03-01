/**
 * msJava
 *
 * @Description 剑指 Offer 04. 二维数组中的查找
 * @Date 2021-02-28
 */
public class Offer04 {

    /**
     * 暴力遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_01(int[][] matrix ,int target){
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
    public boolean findNumberIn2DArray_02(int[][] matrix ,int target){
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
