package com.chao.week08.exercise;

import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/15 13:01
 * @Description 计数排序
 * https://leetcode-cn.com/problems/relative-sort-array/solution/shu-zu-de-xiang-dui-pai-xu-by-leetcode-solution/
 *
 *
 * @Version 1.0
 */
public class AA_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        //   以上构建frequency数组 放 arr1元素出现测次数

        //ans 放结果
        int[] ans = new int[arr1.length];
        int index = 0;
        // 按arr2 的顺序放入ans
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
       // 还剩下没有在arr2 中出现过的元素，因此我们还需要对整个数组 frequency 进行一次遍历。
        // 当遍历到元素 xx 时，如果frequency[x] 不为 0，我们就将frequency[x] 个 x 加入答案中

        // 选取arr1中剩余元素（frequency[] == 0 ）填充到index 及以后。这里有个巧妙点: 从0 到upper 遍历，也自然是从小到大的顺序
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    /**
     * own
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        //计数排序
        //构建frenquency数组
        int max =0;
        for (int i : arr1) {
            max = Math.max(i,max);
        }
        // +1 
        int[] frenquency = new int[max+1];
        for (int i = 0; i < arr1.length; i++) {
           // frenquency[index++] = frenquency[index]++ ;
            frenquency[arr1[i]] = frenquency[arr1[i]] +1;
        }
        //填充arr1的下标
        int[] result = new int[arr1.length];
        int index = 0;
        //按arr2 顺序
        for (int a2 : arr2) {
            while (frenquency[a2] >0){
                result[index++] = a2;
                frenquency[a2] = frenquency[a2] -1;
            }
        }
        //arr2之外 按自然序

        //============有重复的就只处理一次====================
//        for (int i = 0; i <= max; i++) {
//            if (frenquency[i] >0) {
//                result[index++] = i;
//                frenquency[i] = frenquency[i] -1;
//            }
//        }
        //==================================================

        for (int i = 0; i <= max; i++) {
            while (frenquency[i] > 0) {
                result[index++] = i;
                frenquency[i] = frenquency[i] -1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(new AA_RelativeSortArray().relativeSortArray2(arr1,arr2)));

    }
}
