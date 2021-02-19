package com.chao.week01;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/9/14 11:48 下午
 * @Description 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *      初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 *      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Version 1.0
 */
public class C_mergeTwoArray {

    /**
     *
     * @param nums1
     * @param j  nums1中前 j个元素
     * @param nums2
     * @param i nums2中前 i个元素
     */
    public void merge(int[] nums1, int j, int[] nums2, int i) {
        //换成脚标
        j--;
        i--;
        //最终的最后的脚标
        int tail = nums1.length -1;
        while (i >=0){
            if (nums2[i] >= nums1[j]) {
                nums1[tail--] = nums2[i--];
            }else {
                nums1[tail--]=nums1[j--];
            }
        }

    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,7,8,9,0,0,0};
        int[] arr2={4,6,7};
        new C_mergeTwoArray().merge(arr1,6,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }
}
