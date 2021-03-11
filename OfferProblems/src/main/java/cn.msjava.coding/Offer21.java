package cn.msjava.coding;

/**
 * msJava
 *
 * @Description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @Date 2021-02-28
 */
public class Offer21 {

    /**
     * 双指针解法
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums){

        if(nums==null || nums.length==0){
            return null;
        }

        int begin=0;
        int end=nums.length-1;

        while (begin<end){
            // bein 向后移动 直到遇到偶数
            while (begin<end && nums[begin]%2!=0){
                begin++;
            }
            // end 向前移动 直到遇到奇数
            while (begin<end && nums[end]%2==0){
                end--;
            }
            // 交换位置
            if(begin<end){
                int temp=nums[begin];
                nums[begin]=nums[end];
                nums[end]=temp;
            }
        }
        return nums;
    }
}
