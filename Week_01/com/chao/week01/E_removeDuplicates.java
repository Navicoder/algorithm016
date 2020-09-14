package com.chao.week01;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/9/13 9:19 下午
 * @Description  移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class E_removeDuplicates {


    public static void main(String[] args) {
      //int[] arr={1,1};
      int[] arr={0,0,1,0,9,4,0};
       // int i = new E_removeDuplicates().removeDuplicates(arr);
         new E_removeDuplicates().moveZeroes(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 执行用时：
     *      0 ms , 在所有 Java 提交中击败了 100.00%  的用户
     * 内存消耗：
     *       39.9 MB , 在所有 Java 提交中击败了87.91%的用户
     *
     * 21 / 21 个通过测试用例
     * 状态：通过
     * 执行用时: 0 ms
     * 内存消耗: 39.9 MB
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int countZeroBefore =0;
        for(int i =0 ; i< nums.length;i++){
            if (nums[i] == 0) {
                countZeroBefore ++;
            }else{
                if (countZeroBefore >0) {
                    nums[i-countZeroBefore] =nums[i];
                }
            }
        }
        for (int i = nums.length-countZeroBefore; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
