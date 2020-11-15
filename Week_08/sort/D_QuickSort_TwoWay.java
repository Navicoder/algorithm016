package sort;

/**
 * @Author wangwenchao
 * @Date 2020/11/14 01:38
 * @Description 快速排序
 * 找到一个privot ，同时使 privot左边的都小于 privot 右边的;
 * @Version 1.0
 */
public class D_QuickSort_TwoWay {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr,0,arr.length-1);

    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int privot = partion(arr,start,end);
        quickSort(arr,start,privot-1);
        quickSort(arr,privot+1,end);
    }

    /**
     * 核心 找到一个privot ，同时使 privot左边的都小于 privot 右边的;
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partion(int[] arr, int start, int end) {
        return 0;
    }


}
