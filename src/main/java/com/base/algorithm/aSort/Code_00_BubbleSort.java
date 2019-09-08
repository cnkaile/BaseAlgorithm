package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 冒泡排序
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * @Author: zhoukl
 * @Date: 2019-09-08 15:20
 */
public class Code_00_BubbleSort {

    /**
     * 冒泡排序
         * times:限制循环执行次数
         * index:进行比较和交换的标识
     * @param arr   排序数组
     */
    public static void sort_bubble(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //bubble begin
        for (int times = 0; times < arr.length - 1; times++) {
            for (int index = 0; index < arr.length - times - 1; index++) {
                if(arr[index] > arr[index + 1]){
                    BaseUtils.swap_bit(arr, index, index+1);
                }
            }
        }
        //bubble end
    }

    /**
     * 冒泡排序 ： 这样思路更清晰
         * end限制结尾
         * start防止超过end的值
     * @param arr   目标数组
     * @param sign  没有意义，就是重写了方法
     */
    public static void sort_bubble(int[] arr, boolean sign){
        if(null == arr || arr.length < 2){
            return;
        }
        //begin
        for (int end = arr.length - 1; end > 0; end--) {
            for (int start = 0; start < end; start++) {
                if(arr[start] > arr[start + 1]){
                    BaseUtils.swap_bit(arr, start, start + 1);
                }
            }
        }
        //end
    }

    @Test
    public void test01(){
        int is_ok = 0;
        int times = 0;
        for (;times <= 999999; times++){
            int[] source = BaseUtils.generateRandomArray(1000, 1000);
            int[] comparat = BaseUtils.copyArrays(source);
            sort_bubble(source, true);
            BaseUtils.comparator(comparat);
            if(!BaseUtils.isEqual(source, comparat)){
                BaseUtils.printArr(source);
                is_ok = 1;
                break;
            }
        }
        System.out.println(is_ok == 0 ? "yes" : "no");
        System.out.println("times:" + times);
    }

    @Test
    public void test02() {
        boolean is_ok = true;
        int i = 0;
        for (; i < 100220; i++) {
            int[] arrays = BaseUtils.generateRandomArray(100, 100);
            int[] copyArrays = BaseUtils.copyArrays(arrays);
            sort_bubble(arrays);
            BaseUtils.comparator(copyArrays);
            if (!BaseUtils.isEqual(arrays, copyArrays)){
                System.out.println("error");
                is_ok = false;
                break;
            }
        }
        System.out.println(is_ok ? "yes" : "no");
        System.out.println("i:" + i);
    }
}
