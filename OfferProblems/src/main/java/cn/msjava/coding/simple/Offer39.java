package cn.msjava.coding.simple;

import java.util.Arrays;
/**
 * @author msJava
 * @Description: 剑指 Offer 39. 数组中出现次数超过一半的数字 简单
 */
public class Offer39 {

    public static void main(String[] args) {
        int[] nums={1,2,3,2,2,2,5,4,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    //
    public static int majorityElement(int[] nums) {
       if(nums==null){
           return 0;
       }
       Arrays.sort(nums);
       return nums[nums.length/2];
    }
}
