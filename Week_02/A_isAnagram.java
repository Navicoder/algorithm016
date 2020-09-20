import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangwenchao
 * @Date 2020/9/15 11:25 下午
 * @Description
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @Version 1.0
 */
public class A_isAnagram {
    /**
     * 执行用时: 4 ms  60%
     * 内存消耗: 38.7 MB 85%
     * 时间复杂度 排序 O(nlogn) ;比较O(N) 最终O（nlogn）
     * 空间复杂度 O(M + N) 在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)O(n) 额外的空间
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars2);
        System.out.println(chars);
        System.out.println(chars2);

        return String.valueOf(chars).equals(String.valueOf(chars2));
    }

    /**
     * 执行用时: 15 ms 21.91%
     * 内存消耗: 39.4 MB  21.09%
     * 时间复杂度O(M + N)
     * 时间复杂度O(M + N)

     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map1.put(chars[i],map1.getOrDefault(chars[i],0) +1);
        }
        for (int i = 0; i < chars2.length; i++) {
            map2.put(chars2[i],map2.getOrDefault(chars2[i],0) +1);
        }
        if (map2.size() != map1.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !map2.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比2 少用了一个map
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0) +1);
        }
        for (int i = 0; i < chars2.length; i++) {
            Integer num = map.get(chars2[i]);
            if (num !=null) {
                map.put(chars2[i],num-1);
                if (num == 1) {
                    map.remove(chars2[i]);
                }
            }else {
                return false;
            }
        }
        if (map == null || map.size() ==0) {
            return true;
        }
        return false;
    }

    /**
     * 计数器
     * 5ms 49.80%
     * 39M 57.13%
     * 时间 O（N）
     * 空间 O（1）
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //because ingonre digit Case
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //a[i]++; 还可以这样用 没有用过
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String a ="aa";
        String b ="ba";
        System.out.println(new A_isAnagram().isAnagram4(a,b));

        int[] aa = {1,2,3,4};
        aa[2]++;
        System.out.println(aa);

    }
}
