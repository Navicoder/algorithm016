package com.chao.week01;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/9/15 12:23 上午
 * @Description
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 *              0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：
 *      38.2 MB , 在所有 Java 提交中击败了 45.09% 的用户
 *
 * @Version 1.0
 */
public class D_addOne {
    public int[] plusOne(int[] digits) {
       return plusOne(digits,digits.length-1);

    }

    /**
     * 从 尾递减 脚标
     * @param digits
     * @param m
     */
    private int[] plusOne(int[] digits, int m) {
        int original = digits.length;

        if (m < 0) {
            int[] newArr =new int[digits.length+1];
            newArr[0] =1;
            return newArr;
        }
        if (digits[m] ==9) {
            digits = plusOne(digits,m-1);
            //需要区分对待
            if (original == digits.length) {
                digits[m] = 0;
            }
            --m;
        }else{
            digits[m] = digits[m]+1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,9};
        System.out.println(Arrays.toString( new D_addOne().plusOne(arr)));
    }


}
