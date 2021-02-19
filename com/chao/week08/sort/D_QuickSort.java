package com.chao.week08.sort;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/14 01:38
 * @Description 快速排序
 * 找到一个privot ，同时使 privot左边的都小于 privot 右边的; - 超哥推荐
 * @Version 1.0
 */
public class D_QuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr,0,arr.length-1);

    }
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    /**
     * 关键代码
     * @param a
     * @param left
     * @param right
     * @return
     */
    static int partition(int[] a, int left, int right) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = right, counter = left;
        for (int i = left; i < right; i++) {
            if (a[i] < a[pivot]) {
                //int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                //以下两步之后 [0,counter-1]的元素都是小于pivot的 arr[counter]是第一个大于pivot或者下一个要处理的元素
                SortUtil.swapArr3(a,counter,i);
                counter++;
            }
        }
        //int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        //找到了pivot 的位置 counter。【因为0，counter-1的元素都是小于pivot的】
        SortUtil.swapArr2(a,counter,pivot);
        return counter;
    }

    public static void main(String[] args) {
        int[] arr ={7,2,6,1,4,5};
        ///int[] arr ={1,93,2,2,2,11,1,4,5,777,4,32,1,2,3,4,6,7};
        new D_QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));;
    }

}
