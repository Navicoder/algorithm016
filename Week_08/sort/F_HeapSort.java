package sort;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/14 13:34
 * @Description 堆排序 最大堆/最小堆； 先构建 然后取出来pop todo 未理解
 * @Version 1.0
 */
public class F_HeapSort {

    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array, length, largest);
        }
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int length = array.length;
        for (int i = length / 2-1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public static void main(String[] args) {
        //int[] arr ={7,2,6,1,4,5};
        int[] arr ={1,93,2,2,2,11,1,4,5,777,4,32,1,2,3,4,6,7};
        F_HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));;
    }
}
