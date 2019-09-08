package com.base.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * Base Utils
 * @Author: zhoukl
 * @Date: 2019-09-07 17:23
 */
public class BaseUtils {

    /**
     * 经典交换a和b的值
     * @param sortArr   排序数组
     * @param a
     * @param b
     * @return  0
     */
    public static int swap_classic(int[] sortArr, int a, int b){
        int c = sortArr[a];
        sortArr[a] = sortArr[b];
        sortArr[b] = c;
        return 0;
    }

    /**
     * 位运算交换a位置和b位置的值
     * a位置不能等于b位置(a != b)
     * @param sort  排序数组
     * @param a     index_a
     * @param b     index_b
     * @return  1:a == b
     */
    public static int swap_bit(int[] sort, int a, int b){
        if(a == b){
            return 1;
        }
        sort[a] = sort[a] ^ sort[b];
        sort[b] = sort[a] ^ sort[b];
        sort[a] = sort[a] ^ sort[b];
        return 0;
    }

    /**
     * 对数器
     * @param arr   对arr排序
     * @return  0
     */
    public static int comparator(int[] arr){
        Arrays.sort(arr);
        return 0;
    }

    /**
     * 生成随机数组
     * @param maxSize   最大长度
     * @param maxValue  最大值
     * @return  随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int [] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for (int times = 0; times < arr.length; times++){
//            arr[times] = (int) (Math.random() * maxValue);    //只有正数
            arr[times] = ((int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random())); //正和负数
        }
        return arr;
    }

    /**
     * 比较两个数组是否相等
     * @param target    目标数组
     * @param source    源数组
     * @return      true:equal
     */
    public static boolean isEqual(int[] target, int[] source){
        if((null == target && null != target) || (null != target && null == source)){
            return false;
        }
        if(target == null && source == null){
            return true;
        }
        if(target.length != source.length){
            return false;
        }
        for (int index = 0; index < source.length; index++) {
            if(target[index] != source[index]){
                return false;
            }
        }
        return true;
    }

    /**
     * 拷贝复制数组
     * @param source    要复制的数组
     * @return  拷贝完成的数组
     */
    public static int[] copyArrays(int[] source){
        int[] arr = new int[source.length];
        for (int index = 0; index < source.length; index++) {
            arr[index] = source[index];
        }
        return arr;
    }

    /**
     * 打印数组
     * @param arr
     * @return
     */
    public static int printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
        return 0;
    }

    @Test
    public void test(){
        int[] arr = BaseUtils.generateRandomArray(100, 100);
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
