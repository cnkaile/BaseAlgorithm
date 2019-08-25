package com.base.algorithm.aSort;

import java.util.Arrays;

import org.junit.Test;

/**
 * code:    BubbleSort(冒泡排序)
 *
 */
public class Code_00_BubbleSort {

    /**
     * BubbleSort Method
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        //if array's length is 1 or array is null. code end return;
        if(arr == null || arr.length < 2){
            return;
        }
        //bubbleSort begin
        for(int end = arr.length - 1; end > 0; end--){
            //first circulation control end boundary;第一层循环控制结尾的边界
            for(int i = 0; i < end; i++){
                //second circulation control compare time;第二层循环控制比较次数
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }

    //swap array number
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //copy method, copy array values
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }else{
            int[] returnArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++){
                returnArr[i] = arr[i];
            }
            return returnArr;
        }
    }

    //sort comparator. use comparator mySort whether is true;
    //排序比较器，用来比较自己写的排序方法是否正确。
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    //generate random number array;生产随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue){
        //random array length
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        //random array value
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // judge two array value is equal. 判断两个排序后的数组是否一致
    public static boolean isEqual(int[] target, int[] source){
        //judge whether one is null other not null;
        if (target == null && source != null || target != null && source == null){
            System.out.println("null is different");
            return false;
        }
        //judge whether equal two array length
        if(target.length != source.length){
            System.out.println("array length not equal");
            return false;
        }
        //compare two array value is equal
        for (int i = 0; i < target.length; i++){
            if(target[i] != source[i]){
                System.out.println("array length is " + target.length + "  " + source.length +
                        "\n在比较第" + i + "个数字,target : " + target[i] + "和 source：" + source[i] + "时出错");
                return false;
            }
        }
        return true;
    }

    //-----------------------------     test ------------------------------

    //test main
    @Test
    public void testMain(){
        int compareTime = 120000;
        int maxSize = extracted();
        int maxValue = 2000;
        boolean flag = true;

        int i = 0;
        for(i = 0; i < compareTime; i++) {
            //get random array value
            int[] sourceArr = generateRandomArray(maxSize, maxValue);
            int[] targetArr = copyArray(sourceArr);
            //use mySort bubbleSort
            bubbleSort(sourceArr);
            //use compare Sort
            comparator(targetArr);
            //judge two array is equal
            flag = isEqual(targetArr, sourceArr);
            if (flag == false){
                System.out.println("target:");
                printArr(targetArr);
                System.out.println("source:");
                printArr(sourceArr);
                break;
            }
        }
        System.out.println(i);
        System.out.println(flag ? "yes perfect" : "fuck, you are error");
    }

    private int extracted() {
        int maxSize = 100;
        return maxSize;
    }

    // test generate random array
    @Test
    public void testGenerate(){
        int[] arr = generateRandomArray(20,60);
        printArr(arr);
        System.out.println(arr.length + " is arr length");
        //test sort comparator
        comparator(arr);
        printArr(arr);
    }

    //
    public void initTestMySort(String[] args) {
        int[] arr = {2,7,2,3,1,6,3,2};
        bubbleSort(arr);
        printArr(arr);
    }

    //print array
    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
