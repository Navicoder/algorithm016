package com.chao.week08.sort;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/14 12:59
 * @Description 归并排序，先二分拆成数组，子数组有序后 再从下网上归并
 * @Version 1.0
 */
public class E_MergeSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left>=right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);

        //java native方法 用时 要做好校验 不然 IndexOutOfBoundsException ArrayStoreException NPE
        // System.arraycopy(a, start1, b, start2, length)

    }

    private void merge(int[] arr, int left, int mid, int right) {
        if (arr == null || arr.length ==0 || !(right>= mid && mid >=left)) {
            throw new RuntimeException("参数不合法");
        }
        //归并就得开辟一块新空间
        int[] temp = new int[right -left +1];
        //left mid ；mid+1 right
        int i =left,j = mid+1, k =0;
        while (i<=mid && j <= right){
           temp[k++] = arr[i]<arr[j] ? arr[i++]:arr[j++];
        }
        //j 已经遍历完了
        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        //i已经遍历完了
        while (j <= right){
            temp[k++] = arr[j++];
        }
        //copy temp to arr
        for (int l = 0; l < temp.length; l++) {
            arr[l +left ] = temp[l];
        }
    }

    public static void main(String[] args) {
        //int[] arr ={7,2,6,1,4,5};
        int[] arr ={1,93,2,2,2,11,1,4,5,777,4,32,1,2,3,4,6,7};
        new E_MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));;
    }
}
