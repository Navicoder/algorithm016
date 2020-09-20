import java.util.*;

/**
 * @Author wangwenchao
 * @Date 2020/9/16 12:21 上午
 * @Description 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 * @Version 1.0
 */
public class B_groupAnagrams {
    /**
     * 时间复杂度是字符串的最长长度 O（NK）
     * @param strs
     * @return
     * 执行用时：
        2200ms 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗：
        41.8 MB 在所有 Java 提交中击败了 36.80%的用户
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        //会把最后一个元素漏掉，如果之前没有其他元素和它是异位词
        // for (int i = 0; i < strs.length-1; i++) {

        for (int i = 0; i < strs.length; i++) {
            List<String> temp = null;
            if (!used[i]) {
                temp = new ArrayList<String>();
                temp.add(strs[i]);
            }
            for (int j = i+1; j < strs.length; j++) {
                if (used[j]) {
                    continue;
                }
                if (this.equals(strs[i],strs[j])) {
                    used[j]=true;
                    temp.add(strs[j]);
                }
            }
            if (temp != null) {
                l.add(temp);
            }
        }

        return l;
    }

    /**
     * 时间复杂度是字符串的最长长度 O（K）
     */
    private boolean equals(String s1,String s2){
        if (s1.length() !=s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(s2.charAt(i))) {
                return false;
            }
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0) - 1);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时：
     * 7 ms 在所有 Java 提交中击败了 99.03% 的用户
     * 内存消耗：
     *  41.8 MB  在所有 Java 提交中击败了 44.47% 的用户
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> l = new ArrayList<>();
        Map<String,List<String>> keyMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);//String key2 = String.valueOf(chars);
            if (keyMap.containsKey(key)) {
                keyMap.get(key).add(strs[i]);
            }else{
                List<String> keyList = new ArrayList<>();
                keyList.add(strs[i]);
                keyMap.put(key,keyList);
            }
        }
        Collection<List<String>> values = keyMap.values();

        return new ArrayList<List<String>>(values);
    }


        public static void main(String[] args) {
        String[] aa ={"eat", "bat", "tan", "ate", "nat", "tea"};
        System.out.println(new B_groupAnagrams().groupAnagrams2(aa));
    }


}
