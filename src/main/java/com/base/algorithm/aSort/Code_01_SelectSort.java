package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 选择排序
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * @Author: zhoukl
 * @Date: 2019-09-08 16:06
 */
public class Code_01_SelectSort {

    /**
     * 选择排序
     * @param arr   目标数组
     */
    public static void sort_select(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //begin
        for (int begin = 0; begin < arr.length - 1; begin++) {
            int minIndex = begin;
            for (int end = begin + 1; end < arr.length; end++) {
                if(arr[minIndex] > arr[end]){
                   minIndex = end;
                }
            }
            BaseUtils.swap_bit(arr, begin, minIndex);
        }
        //end
    }

    @Test
    public void test01(){
        int isok = 0;
        int times = 0;
        for (; times < 9999; times++) {
            int[] source = BaseUtils.generateRandomArray(1000, 1000);
            int[] comparator = BaseUtils.copyArrays(source);
            sort_select(source);
            BaseUtils.comparator(comparator);
            if(!BaseUtils.isEqual(source, comparator)){
                isok = 1;
                BaseUtils.printArr(source);
                BaseUtils.printArr(comparator);
                break;
            }
        }
        System.out.println();
        System.out.println(isok == 0 ? "yes" : "error");
        System.out.println("times:" + times);
    }
}
