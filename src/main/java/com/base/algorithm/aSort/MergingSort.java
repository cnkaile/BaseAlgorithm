package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 合并排序输入法
 * @Author zhoukl
 * @Date 2020/1/4 17:12
 */
public class MergingSort implements BaseSort {

    @Override
    public int[] sort(int[] arr) {
        merginSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 合并排序核心算法
     */
    private int[] merginSort(int[] arr, int begin, int end) {
        if(begin >= end){
            return arr;
        }
        int center = begin + ((end - begin) >> 1);
        merginSort(arr, begin, center);
        merginSort(arr, center + 1, end);
        //合并
        mergin(arr, begin, center, end);
        return arr;
    }

    private int[] mergin(int[] arr, int begin, int center, int end) {
        int[] swap = new int[end - begin + 1];
        int left = begin;
        int right = center + 1;
        int index = 0;
        while (left <= center && right <= end){
            swap[index++] = arr[left] > arr[right] ? arr[right++] : arr[left++];
        }
        //查看是否重置完全
        while (left <= center){
            swap[index++] = arr[left++];
        }
        while (right <= end){
            swap[index++] = arr[right++];
        }
        //查看是否重置完全
        //并入source
        for (int i = 0; i < swap.length; i++) {
            arr[begin++] = swap[i];
        }
        return arr;
    }

    @Test
    public void testSort(){
        boolean b = BaseUtils.exeSortMethod(new MergingSort());
        System.out.println(b);
    }


}
