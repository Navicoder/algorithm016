package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WaterArea {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        //int[] arr = {1};
        List<List<Integer>> lists = new WaterArea().threeSum(arr);
        System.out.println(lists);
    }
    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) break;//i之后的都是大于0的 和不可能大于0
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int L=i+1;
            int R=len-1;
            while (L< R){
                int sum=nums[i]+nums[L]+nums[R];
                if (sum==0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //重复的的 不算 a即 arr[3]==arr[4]时 数值是一个 就用arr[3]的值 就行了
                    while (L< R && nums[L]==nums[L+1]) L++;
                    while (L< R && nums[R]==nums[R-1]) R--;

                    //为什么有++ --
                    L++;
                    R--;
                }else if (sum >0) {
                    R--;
                }else {
                    L++;
                }
            }
        }
        CountDownLatch cdl = new CountDownLatch(8);
        // -- thread
        cdl.countDown();

        //最后
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ans;
    }

}