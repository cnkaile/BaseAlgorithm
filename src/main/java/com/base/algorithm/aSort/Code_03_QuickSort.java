package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 时间复杂度：O(N*logN)
 * 空间复杂度：O(log2N)
 * 快排：
 * 1、当前值(index) < 目标值, 当前值和小于区后一个数交换, 小于区向右扩一位, 当前值++;
 * 2、当前值(index) == 目标值, 当前值后移(index++);
 * 3、当前值(index) > 目标值, 当前值与大于区前一个数交换, 大于去向左扩一位, 当前值不变.
 * 随机快排：
 * 目标值随机产生,然后目标值和数组最后一位交换。
 * @ClassName: Code_03_QuickSort
 * @Author: zhoukl
 * @Date: 2019/9/11 11:55
 * @Version: 1.0
 */
public class Code_03_QuickSort {

    /**
     * 快排
     * @param arr   目标数组
     * @return  0
     */
    public static int sort_quick(int[] arr){
        if(null == arr || arr.length < 2){
            return 1;
        }
        sort_quick(arr, 0, arr.length - 1);
        return 0;
    }

    /**
     * 快排实现
     * @param arr
     * @param left
     * @param right
     */
    private static void sort_quick(int[] arr, int left, int right) {
        if(left < right){
            BaseUtils.swap_bit(arr, left + ((int) (Math.random() * (right - left + 1))), right);
            int[] partition = sort_partition(arr, left, right);
            sort_quick(arr, left, partition[0]);
            sort_quick(arr, partition[1], right);
        }
    }

    /**
     * 分区
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] sort_partition(int[] arr, int left, int right){
        //left: 当前值; right: 选定值
        int less = left - 1;
        int more = right;
        while (left < more){
            if(arr[left] < arr[right]){
                BaseUtils.swap_bit(arr, ++less, left++);
            }
            else if(arr[left] == arr[right]){
                left ++;
            }
            else{
                BaseUtils.swap_bit(arr, --more, left);
            }
        }
        BaseUtils.swap_bit(arr, left, right);
        return new int[]{less, ++more};
    }

    @Test
    public void test(){
        int times = 0;
        int isok = 0;
        for(; times < 5000; times ++){
            int[] source = BaseUtils.generateRandomArray(1000, 1000);
            int[] target = BaseUtils.copyArrays(source);
            sort_quick(source);
            BaseUtils.comparator(target);
            if(!BaseUtils.isEqual(source, target)){
                BaseUtils.printArr(source);
                BaseUtils.printArr(target);
                isok = 1;
                break;
            }
        }
        System.out.println(isok == 0 ? "ok" : "fail");
        System.out.println("times:" + times);
    }
}
