package src.immoc.sort;

import src.utils.Utils;

public class E_QuickSort2Ways_MK {

    // 我们的算法类不允许产生任何实例
    private E_QuickSort2Ways_MK(){}

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(int[] arr, int l, int r){
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        int v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // 注意这里的边界, arr[i]-(v) < 0, 不能是arr[i]-(v) <= 0
            // 思考一下为什么?
            while( i <= r && arr[i]-(v) < 0 )
                i ++;

            // 注意这里的边界, arr[j]-(v) > 0, 不能是arr[j]-(v) >= 0
            // 思考一下为什么?
            while( j >= l+1 && arr[j] > v )
                j --;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html

            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r){
        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            B_InsertionSort.SORT_INSERT2(arr,l,r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 Quick Sort 2 Ways
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int[] arr = Utils.createRandomArr(100,10000);
        sort(arr);
        System.out.println(Utils.printIntSZ(arr));

        return;
    }
}