package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author wangwenchao
 * @Date 2020/11/15 20:18
 * @Description 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词-[由相同的字母按照不同的顺序组成的单词]。
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 *
 *
 * 标签：哈希映射; 计数排序
 * 首先判断两个字符串长度是否相等，不相等则直接返回 false
 * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
 * s 负责在对应位置增加，t 负责在对应位置减少
 * 如果哈希表的值都为 0，则二者是字母异位词
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class B_IsAnagram {
    /**
     * 38ms
     * 利用hash
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (Objects.isNull(s) && Objects.isNull(t) ) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer times = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i),times+1);
            Integer times2 = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i),times2-1);
        }
        Optional<Integer> any = map.values().stream().filter(i -> i.intValue() != 0).findAny();
        return !any.isPresent();
    }

    /**
     * 5ms
     *  isAnagram2 与 isAnagram3的差别就在 是不是先把string 转成了数组
     * 利用数组
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (Objects.isNull(s) && Objects.isNull(t) ) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] digit = new int[26];
        for (int i = 0; i < s.length(); i++) {
            digit[s.charAt(i) -'a']++;
            digit[t.charAt(i) -'a']--;
        }
        //优化版
//        char[] charss = s.toCharArray();
//        char[] charst = t.toCharArray();
//        for (int i = 0; i < charss.length; i++) {
//            digit[charss[i] - 'a']++;
//            digit[charst[i] - 'a']--;
//        }


        for (int i : digit) {
            if (i !=0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 2ms
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if (Objects.isNull(s) && Objects.isNull(t) ) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnts = new int[26];
        for(char c: s.toCharArray()){
            cnts[c-'a']++;
        }
        for(char c: t.toCharArray()){
            cnts[c-'a']--;
        }
        for(int cnt : cnts){
            if(cnt!=0) return false;
        }
        return true;


    }

    public static void main(String[] args) {
        //"anagram"
        //"nagaram"
        boolean anagram = new B_IsAnagram().isAnagram("anagram", "nagaram");
    }
}
