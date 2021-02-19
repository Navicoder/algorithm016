package com.chao.week03;

/**
 * @Author wangwenchao
 * @Date 2020/11/22 18:58
 * @Description 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class A_ClimbingStairs {
    public int climbStairs(int n) {
        int[] arr =  new int[n];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] =1;
            }else if (i == 1) {
                arr[i] =2;
            }else {
                arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[n-1];
    }
    public int climbStairs2(int n) {
        int[] arr =  new int[n];
        for (int i = 0; i < arr.length; i++) {

        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] =1;
            }else if (i == 1) {
                arr[i] =2;
            }else {
                arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[n-1];
    }

}
