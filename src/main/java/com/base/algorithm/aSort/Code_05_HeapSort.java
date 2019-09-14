package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import com.sun.xml.internal.ws.assembler.jaxws.BasicTransportTubeFactory;
import org.junit.Test;

/**
 * 堆排序:
 *      1、大头堆： 把数组改成大头堆模式，第一个就是最大的，依次放到最后。最终完成排序
 * @Author: zhoukl
 * @Date: 2019-09-13 21:50
 */
public class Code_05_HeapSort {

    /**
     * 堆排序
     * @param arr   目标数组
     * @return  0
     */
    public static int sort_heap(int[] arr){
        if(null == arr || arr.length < 2){
            return 1;
        }
        //把现有数组改变成堆结构
        for (int times = 0; times < arr.length; times++) {
            create_heap(arr, times);
        }
        int size = arr.length;
        while (size > 0){
            restart_create_heap(arr, 0, size);
            BaseUtils.swap_bit(arr,0, --size);
        }
        return 0;
    }

    /**
     * 重新构建堆
     * @param arr   目标数组
     * @param size  目标数组最大
     * @return  0
     */
    public static int restart_create_heap(int[] arr,int index, int size){
        int next = index * 2 + 1;
        while (next < size){
            next = (next + 1 < size && (arr[next] < arr[next + 1])) ? next + 1 : next;
            if(arr[index] < arr[next]){
                BaseUtils.swap_bit(arr, index, next);
                index = next;
                next = index * 2 + 1;
            }else{
                break;
            }
        }
        return 0;
    }

    /**
     * 把现有数组改变成堆结构
     * @param arr   目标数组
     * @param index 排序下标
     * @return  0
     */
    public static int create_heap(int[] arr, int index){
        while (arr[index] > arr[((index - 1) / 2)]){
            BaseUtils.swap_bit(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        return 0;
    }

    @Test
    public void test(){
        int times = 0;
        int ok = 0;
        for(; times < 10000; times++){
            int[] resource = BaseUtils.generateRandomArray(1000, 1000);
            int[] target = BaseUtils.copyArrays(resource);
            sort_heap(resource);
            BaseUtils.comparator(target);
            if(!BaseUtils.isEqual(resource,target)){
                BaseUtils.printArr(resource);
                BaseUtils.printArr(target);
                ok = 1;
                break;
            }
        }
        System.out.println(ok == 0 ? "ok" : "fail");
        System.out.println("times:" + times);
    }

}
