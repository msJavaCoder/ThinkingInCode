import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author msJava
 * @Description: 剑指 Offer 03. 数组中重复的数字
 */
public class Offer03 {


    public static int findRepeatNumber_01(int[] nums){
        Arrays.sort(nums);
        for (int i=0 ; i<nums.length ; i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }

        return -1;
    }

    public static int findRepeatNumber_02(int[] nums){
        Set<Integer> set=new HashSet<Integer>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }

    public static int findRepeatNumber_03(int[] nums) {
        for (int i=0 ; i<nums.length ; i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums={2,3,1,0,2,5,3};
        int number01 = findRepeatNumber_01(nums);
        int number02 = findRepeatNumber_02(nums);
        int number03 = findRepeatNumber_03(nums);
        System.out.println(number01+" "+number02+" "+number03+" ");
    }
}
