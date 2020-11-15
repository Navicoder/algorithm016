package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author wangwenchao
 * @Date 2020/11/15 21:11
 * @Description
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * [1,2,8,15]
 * [3,6,10,18]
 *
 * [1,2,8,15]
 * [3,9,10,18]
 *
 *
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * //todo 理解
 * @Version 1.0
 */
public class C_MergeArea {
    public int[][] merge(int[][] intervals) {
        List<int[]> inter = Arrays.asList(intervals);
        List<int[]> newInter = new ArrayList<>(inter);
        //        newInter.sort((o1, o2) -> o1[0] - o2[0]);
        newInter.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < newInter.size(); ){
            int right = newInter.get(i)[1];
            int j = i + 1;
            while(j < newInter.size() && newInter.get(j)[0] <= right){
                right = Math.max(right, newInter.get(j)[1]);
                j++;
            }
            res.add(new int[]{newInter.get(i)[0], right});
            i = j;
        }

        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }


}

