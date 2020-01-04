package com.base.algorithm.aSort;

import com.base.util.BaseUtils;
import org.junit.Test;

/**
 * 快排
 */
public class QuickSort implements BaseSort{

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
        BaseUtils.exeSortMethod(new QuickSort());
    }

    @Override
    public int[] sort(int[] arr) {
        sort_quick(arr);
        return arr;
    }
}
