package com.base.algorithm.aSort;

import com.base.algorithm.aSort.baseInterface.BaseSort;
import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * @Author zhoukl
 * @Date 2020/1/4 21:11
 */
public class HeapSort implements BaseSort {
    @Override
    public int[] sort(int[] arr) {
        if(arr == null || arr.length < 2){
            return arr;
        }
        //创建堆模型
        createHeap(arr);
        //堆排序
        int end = arr.length;
        while (end > 0){
            resart_create_heap(arr, 0, end);
            BaseUtils.swap_bit(arr, 0, --end);
        }
        return arr;
    }

    private int[] resart_create_heap(int[] arr, int index, int end) {
        int next = (index * 2) + 1;
        while (next < end){
            next = (next + 1 < end) && arr[next] < arr[next + 1] ? next + 1 : next;
            if(arr[index] < arr[next]){
                BaseUtils.swap_bit(arr, index, next);
                index = next;
                next = (next * 2) + 1;
            }else{
                break;
            }
        }
        return arr;
    }

    private int[] createHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            selectBigRoot(arr, i);
        }
        return arr;
    }

    /**
     * 与各个父节点比较
     * @param arr
     * @param index
     * @return
     */
    private int[] selectBigRoot(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            BaseUtils.swap_bit(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        return arr;
    }

    @Test
    public void test_sort (){
        boolean b = BaseUtils.exeSortMethod(new HeapSort());
        System.out.println(b);
    }
}
