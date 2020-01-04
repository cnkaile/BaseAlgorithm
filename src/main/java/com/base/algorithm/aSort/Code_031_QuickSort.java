package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 快排
 */
public class Code_031_QuickSort {

    public int[] sort_quick(int[] source) {
        if (source == null || source.length < 2) {
            return source;
        }
        sort_quick(source, 0, source.length - 1);
        return source;
    }

    public int[] sort_quick(int[] source, int begin, int end) {
        if (begin < end) {
            BaseUtils.swap_bit(source, (begin + ((int)(Math.random() * (end - begin + 1)))), end);
            int[] divide = divide(source, begin, end);
            sort_quick(source, begin, divide[1]);
            sort_quick(source, divide[0], end);
        }
        return source;
    }

    public int[] divide(int[] source, int begin, int end) {
        //从小到大
        int small = begin - 1;
        int big = end;
        int index = begin;
        while (index < big){
            if(source[index] > source[end]){
                BaseUtils.swap_bit(source, index, --big);
            }else if(source[index] < source[end]){
                BaseUtils.swap_bit(source, index++, ++small);
            }else{
                index++;
            }
        }
        BaseUtils.swap_bit(source, big++, end);
        return new int[]{big, small};
    }

    @Test
    public void test(){
        int times = 0;
        int isok = 0;
        long s = System.currentTimeMillis();
        for (times = 0; times < 100; times++) {
            int[] source = BaseUtils.generateRandomArray(10000, 1000);
            int[] target = BaseUtils.copyArrays(source);
            sort_quick(source);
            BaseUtils.comparator(target);
            if(!BaseUtils.isEqual(source, target)){
                BaseUtils.printArr(source);
                BaseUtils.printArr(target);
                isok = 1;
                break;
            }else{
                System.out.println(times);
            }
        }
        long e = System.currentTimeMillis();
        System.out.println((e - s) / 1000);
        System.out.println(isok == 0 ? "ok" : "fail");
        System.out.println("times:" + times);
    }
}
