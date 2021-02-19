package com.chao.week02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author wangwenchao
 * @Date 2020/9/20 4:38 下午
 * @Description 最小的k个数
 *    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @Version 1.0
 */
public class E_getLeastNumbers {
    /**
     * 执行用时：
     *      7 ms , 在所有 Java 提交中击败了  68.97% 的用户
     * 内存消耗：
     *      40 MB , 在所有 Java 提交中击败了 75.66% 的用户
     *
     *
     * 时间复杂度：排序O(NLogN) + O(k) = O(NLogN)
     * 空间复杂度： O(N)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }

    /**
     * 用最小堆 - jdk的堆实现PriorityQueue
     *
     * 执行用时：
     *     26 ms , 在所有 Java 提交中击败了 17.36% 的用户
     * 内存消耗：
     *      39.6 MB , 在所有 Java 提交中击败了 97.67% 的用户
     *
     * 时间复杂度：是多少 todo
     * 空间复杂度：是多少 todo
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        //最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = priorityQueue.poll();
        }
        return ints;
    }

        public static void main(String[] args) {
        int[] aa = {3,2,1};
        int[] leastNumbers = new E_getLeastNumbers().getLeastNumbers2(aa, 2);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
