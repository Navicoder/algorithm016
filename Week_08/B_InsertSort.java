import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/13 23:53
 * @Description 插入排序
 * [0,i-1]已经有序，从 i开始 把之后的插入到之前的合适位置
 * @Version 1.0
 */
public class B_InsertSort {

    public void sort(int[] arr){
        if (arr == null || arr.length==0) {
            return;
        }
//        for (int i = 0; i < arr.length-1; i++) {
//            /**
//             * 找i合适的位置，一次交换
//             */
//            int iIndex = i;
//            for (int j = i+1; j < arr.length; j++) {
//                // [] i ...    i插入到之前的有序
//                if (arr[j] >= arr[j-1]) {
//                    continue;
//                }else{
//                    int a =i -1;
//                    int val = arr[j];
//                    while (a >=0 && arr[a] > val){
//                        a--;
//                    }
//                    //把 a 到i-1向右挪一
//
//                }
//
//            }
//        }

        //外层从1 开始
        for (int i = 1; i < arr.length; i++) {
            /**
             * 找到 i 合适的地方
             */
            int iIndex =i;
            //内层从 i开始向左边 -【保证左边已经有序】
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] >= arr[j]) {
                    break;//直接排序i++
                }else{
                   //找到i的位置
                    iIndex = j;
                }
            }
            //把 iIndex～【i-1】往右一个，并把 arr[i] 放置arr[iIndex]
            int iVal = arr[i];
            //会覆盖 所以要倒着复制
//            for (int k = iIndex; k <=i-1; k++) {
//                arr[k+1] = arr[k];
//            }
            for (int k = i-1; k >= iIndex; k--) {
                arr[k+1] = arr[k];
            }
            arr[iIndex] =iVal;
        }
    }
    //function insertionSort(arr) {
    //    varlen = arr.length;
    //    varpreIndex, current;
    //    for(vari = 1; i < len; i++) {
    //        preIndex = i - 1;
    //        current = arr[i];
    //        while(preIndex >= 0 && arr[preIndex] > current) {
    //            arr[preIndex + 1] = arr[preIndex];
    //            preIndex--;
    //        }
    //        arr[preIndex + 1] = current;
    //    }
    //    returnarr;
    //}

    private void swapArr(int[] arr, int i, int minIndex) {
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
    private void swapArr2(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
    /**
     *  异或
     */

    private void swapArr3(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr ={1,93,2,2,2,11,1,4,5,777,4,32,1,2,-1,3,4,6,7};
        new B_InsertSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println( 1^ 1);

    }
}
