package src.leetcode;

import java.util.*;

public class ThreeNums {
    //双指针1
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;//i之后的都是大于0的 和不可能大于0
            if(i > 0 && nums[i] == nums[i-1]){//判重1最小值的判重
                continue;
            }
            //双指针
            int L=i+1,R=len-1;
            while (L< R){
                long sum = nums[i]+nums[L]+nums[R];
                if (sum >0) {
                    R--;
                }else if( sum<0){
                    L++;
                }else {
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
/*
                    //重复的的 不算 a即 arr[3]==arr[4]时 数值是一个 就用arr[3]的值 就行了; 判重2 后两个数的判重
                    while (L< R && nums[L]==nums[L+1]) L++;
                    while (L< R && nums[R]==nums[R-1]) R--;

                    //为什么有++ --
                    //因为上两个while终止时，对应的 ++ -- 没有执行。L R 还是==0时的元素或者相同的元素，需要++ -- 让它向后走
                    L++;
                    R--;
*/

                    //可以用下边两行优化替代
                    while (L< R && nums[L] == nums[++L]);
                    while (L< R && nums[R] == nums[--R]) ;

                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeNums().threeSum(new int[]{1, 2, -3, 4, 5, -6});
        lists.forEach(i -> System.out.println(i));
    }

}
