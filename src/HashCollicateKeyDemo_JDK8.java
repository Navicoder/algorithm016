package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 模拟数组容量为16的hash冲突
 * {0=[0, 32, 64, 96, 128, 16, 48, 80, 112]}
 */
public class HashCollicateKeyDemo_JDK8 {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (ifStop(map)) {
                System.out.println(map);
                return;
            }
            int hash = hash(i);
            int n = 16;
            int index = (n - 1) & hash;
            Set<Integer> integers = map.computeIfAbsent(index, k -> new HashSet());
            integers.add(i);
            map.put(index,integers);
        }



    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    static final boolean ifStop(Map<Integer, Set<Integer>> map) {
        if (map == null || map.size()==0) {
            return false;
        }
        for (Set<Integer> value : map.values()) {
            if (value.size() > 8) {
                return true;
            }
        }
        return false;
    }
}
