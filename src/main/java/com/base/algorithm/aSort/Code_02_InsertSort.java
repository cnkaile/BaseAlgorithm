package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 插入排序
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * @Author: zhoukl
 * @Date: 2019-09-08 17:14
 */
public class Code_02_InsertSort {

    /**
     * 插入排序
     * @param arr   目标数组
     * @return  1/0
     */
    public static int sort_insert(int[] arr){
        if(null == arr || arr.length < 2){
            return 1;
        }
        //begin
        for (int orderedArea = 0; orderedArea < arr.length - 1; orderedArea++) {
            for (int insert = orderedArea + 1; insert > 0; insert--) {
                if(arr[insert] < arr[insert - 1]){
                    BaseUtils.swap_bit(arr, insert, insert - 1);
                }else{
                    break;
                }
            }
        }
        //end
        return 0;
    }

    @Test
    public void test(){
        int isok = 0;
        int times = 0;
        for (; times < 99999; times++) {
            int[] source = BaseUtils.generateRandomArray(1000, 1000);
            int[] target = BaseUtils.copyArrays(source);
            sort_insert(source);
            BaseUtils.comparator(target);
            if(!BaseUtils.isEqual(source, target)){
                isok = 1;
                BaseUtils.printArr(source);
                BaseUtils.printArr(target);
                break;
            }
        }
        System.out.println();
        System.out.println(isok == 0 ? "success" : "fail");
        System.out.println("times:"  + times);
    }
}
