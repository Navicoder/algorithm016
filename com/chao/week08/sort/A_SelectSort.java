package com.chao.week08.sort;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/13 23:53
 * @Description 选择排序 每次选出来一个最小的,然后替换
 * @Version 1.0
 */
public class A_SelectSort {

    public void sort(int[] arr){
        if (arr == null || arr.length==0) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            /**
             * 保存最小值[可以用最小索引] 最小索引
             */
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortUtil.swapArr3(arr,i,minIndex);
            }
        }
    }



    public static void main(String[] args) {
        int[] arr ={1,93,2,2,2,11,1,4,5,777,4,32,1,2,-1,3,4,6,7};
        new A_SelectSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println( 1^ 1);

    }
}
