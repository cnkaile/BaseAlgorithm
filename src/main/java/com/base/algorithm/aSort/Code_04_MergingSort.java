package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 归并排序
 * 时间复杂度：log(N*logN)
 * @Author: zhoukl
 * @Date: 2019-09-13 15:57
 */
public class Code_04_MergingSort {

    /**
     * 归并排序：
     *      左面排序，右边排序，完成后合并到其他数组
     * @param arr   目标数组
     * @return  0
     */
    public static int sort_merging(int[] arr){
        if(null == arr || arr.length < 2){
            return 1;
        }
        sort_merging(arr, 0, arr.length - 1);
        return 0;
    }

    public static int sort_merging(int[] arr, int left, int right){
        if (left == right){
            return 1;
        }
        int mid = left + ((right - left) >> 1);
        sort_merging(arr, left, mid);
        sort_merging(arr, mid + 1, right);

        //mid左边和右边都有序了，进行合并
        merging(arr, left, mid, right);
        return 0;
    }

    public static int merging(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int helpIndex = 0;
        int index1 = left;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= right){
            help[helpIndex++] = arr[index1] > arr[index2] ? arr[index2++] : arr[index1++];
        }
        while (index1 <= mid){
            help[helpIndex++] = arr[index1++];
        }
        while (index2 <= right){
            help[helpIndex++] = arr[index2++];
        }
        for (int times = 0; times < help.length; times++) {
            arr[left + times] = help[times];
        }
        return 0;
    }

    @Test
    public void test(){
        int times = 0;
        int ok = 1;
        for(; times < 1000; times ++ ){
            int[] source = BaseUtils.generateRandomArray(999999, 10000);
            int[] target = BaseUtils.copyArrays(source);
            sort_merging(source);
            BaseUtils.comparator(target);
            if(!BaseUtils.isEqual(source, target)){
                BaseUtils.printArr(source);
                BaseUtils.printArr(target);
                ok = 0;
                break;
            }
        }
        System.out.println(ok == 1 ? "ok" : "fail");
        System.out.println("times:" + times);
    }
}
