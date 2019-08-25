package com.base.util;

/**
 * use XOR(^) operation replace assignment swap int or char.
 * 使用异或运算代替通常的赋值交换。
 */
public class MySwap{
    
    private static void swapChar(char[] arr, int i, int j){
        //(int)arr[i] ^ (int)arr[j];
        arr[i] = (char)((int)arr[i] ^ (int)arr[j]);
        arr[j] = (char)((int)arr[i] ^ (int)arr[j]);
        arr[i] = (char)((int)arr[i] ^ (int)arr[j]);
    }

    private static void swapInt(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private static void myPrintChar(char[] arr){
        for (char c : arr) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static void myPrintInt(int[] arr){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] arg){
        char[] arr = {'a','2','c'};
        myPrintChar(arr);
        swapChar(arr,0,1);
        myPrintChar(arr);
        //int
        System.out.println("---------  int ----------");
        int[] arrI = {1,2,3,4};
        myPrintInt(arrI);
        swapInt(arrI,1,2);
        myPrintInt(arrI);
    }
}