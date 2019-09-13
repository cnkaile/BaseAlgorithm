package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 快排：
 * 时间复杂度：O(N * logN)
 * 空间复杂度：O(log2N)
 * 1、当前值(index) < 选定值, 当前值和小于区后一位交换,小于区向右扩展一位, 当前值++;
 * 2、当前值(index) == 选定值, 当前值++;
 * 3、当前值(index) > 选定值, 当前值和大于区前一位交换, 大于区向左扩一位, 当前值不变++.
 * 随机快排：
 * 选定值随机, 然后和最后一位交换.
 *
 * @Author: zhoukl
 * @Date: 2019-09-08 17:14
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
     * 随机快排递归函数
     * @param arr   目标数组
     * @param left  排序开始位置
     * @param right 排序结束位置
     */
    private static void sort_quick(int[] arr, int left, int right) {
        if(left < right){   //结束判断
            BaseUtils.swap_bit(arr, (left + ((int) (Math.random() * (right - left + 1)))), right);
            int[] region = sort_region(arr, left, right);
            sort_quick(arr, left, region[0]);
            sort_quick(arr, region[1], right);
        }
    }

    /**
     * 给数组分区:
     *  选定值为区域最后一个.
     *      中间等于选定值区域
     *      左面小于选定值区域
     *      右边大于选定值区域
     * @param arr   目标数组
     * @param left  数组左侧
     * @param right 数组右侧
     * @return  index[0] 小于区域结束下标; index[1] 大于区域开始下标
     */
    private static int[] sort_region(int[] arr, int left, int right) {
        int index = left;   //当前值
        int comp = right;   //选定值
        int lessThan = left - 1;    //小于区
        int moreThan = right;   //大于区
        while (index < moreThan){
            if(arr[index] < arr[comp]){
                BaseUtils.swap_bit(arr, ++lessThan, index++);
            }
            else if(arr[index] == arr[comp]){
                index++;
            }
            else{
                BaseUtils.swap_bit(arr, index, --moreThan);
            }
        }
        BaseUtils.swap_bit(arr, index, comp);
        return new int[]{lessThan, moreThan + 1};
    }

    @Test
    public void test(){
        int times = 0;
        int isok = 0;
        for (times = 0; times < 100000; times++) {
            int[] source = BaseUtils.generateRandomArray(100000, 1000);
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
