package com.chao.week08.sort;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/14 01:47
 * @Description
 * @Version 1.0
 */
public class SortUtil {

    public static void swapArr(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    /**
     * 不用额外空间 可能会超精度
     * @param arr
     * @param i
     * @param j
     */
    public static void swapArr2(int[] arr, int i, int j) {
        /**
         * 必须判断 不然操作后该角标的值就是0 了
         */
        if (i == j) {
            return;
        }
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
    public static void swapArr3(int[] arr, int i, int j) {
        /**
         * 必须判断 不然操作后该角标的值就是0 了
         */
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr ={1,93,1,2,2,11,1,4,5,777,4,32,1,2,3,4,6,7};
        swapArr3(arr,0,0);
        System.out.println(Arrays.toString(arr));
    }

}
