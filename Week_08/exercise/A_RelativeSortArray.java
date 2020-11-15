package exercise;

import sort.SortUtil;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/15 11:02
 * @Description
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * @Version 1.0
 */
public class A_RelativeSortArray {
    /**
     * 暴力
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        if (arr2 == null || arr2.length == 0 || arr1==null ||arr1.length==0) {
            return arr1;
        }
        //arr1 下一个排序的角标
        int nextToOrder=0;
        // i+1 > arr2Length arr2 长于arr1
        int arr1Length = arr1.length;
        for (int i = 0; i < arr2.length ; i++) {
            if (i >0 && arr2[i] == arr2[i-1]) {
                continue;
            }
            //先按arr2的顺序排序
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    if (nextToOrder !=j) {
                        SortUtil.swapArr3(arr1,nextToOrder,j);
                    }
                    nextToOrder++;
                }
            }
        }
        //nextToOrder 以及之后的按升序排序 因为 nextToOrder++; 所以 最后一个元素时, ++ 以后 就等于了 arr1.length；但最后一个元素时 也不用生序排序了
        //if (nextToOrder <= arr1.length) {
        if (nextToOrder < arr1.length) {
            orderAsc(arr1,nextToOrder,arr1.length-1);
        }

        return arr1;
    }

    /**
     * 这里直接用Arrays.sort(arr1,left,right);
     * @param arr1
     * @param left
     * @param right
     */
    private void orderAsc(int[] arr1, int left, int right) {
        Arrays.sort(arr1,left,right);
    }

    public static void main(String[] args) {
////        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
////        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
//
//        int[] arr1 = new int[]{28,6,22,8,44,17};
//        int[] arr2 = new int[]{22,28,8,6};
//
////        int[] arr1 = new int[]{2, 3,1, 4,5};
////        int[] arr2 = new int[]{2, 1,4,5,3,7,7};
//        System.out.println(Arrays.toString(new A_RelativeSortArray().relativeSortArray1(arr1,arr2)));
        int[] a = new int[]{22,28,88,63,44,17};
        System.out.println(Arrays.toString(a));

        Arrays.sort(a,3,5);
        System.out.println(Arrays.toString(a));
    }
}
