package cn.msjava.coding;

/**
 * @author msJava
 * @Description: 快速排序-双边循环
 */
public class QuickSort {

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex=partition_02(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);

    }

    /**
     * 双边循环 递归方式
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition_01(int[] arr,int startIndex,int endIndex){

        int pivot=arr[startIndex];
        int left=startIndex;
        int right=endIndex;

        while (left!=right){

            while (left<right && arr[right]>pivot){
                right--;
            }
            while (left<right && arr[left]<=pivot){
                left++;
            }
            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            arr[startIndex]=arr[left];
            arr[left]=pivot;
        }
        return left;
    }


    /**
     * 单边循环  递归方式
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition_02(int[] arr,int startIndex,int endIndex){

        int pivot=arr[startIndex];
        int mark=startIndex;

        for (int i = startIndex+1; i <=endIndex ; i++) {
            if(arr[i]<pivot){
                mark++;
                int temp=arr[mark];
                arr[mark]=arr[i];
                arr[i]=temp;
            }
        }

        arr[startIndex]=arr[mark];
        arr[mark]=pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr={2,12,5,8,7,9,8};
        quickSort(arr,0,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
