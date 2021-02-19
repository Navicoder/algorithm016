package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * hash 冲突
 */
public class HashMaoTest_JDK8 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            integers.add(i);
            ThreadPoolExecutor p = null;
            p.shutdown();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //0, 32, 64, 96, 128, 16, 48, 80, 112
        int[] a = {0, 32, 64, 96, 128, 16, 48, 80, 112};

//        for (int i : a) {
//            hashMap.put(i,i);
//        }
        for (int i = 0; i < 12; i++) {
            hashMap.put(i,i);
        }
        hashMap.remove(1);
        hashMap.put(32,33);
        hashMap.put(64,77);

        System.out.println(hashMap.size());
        System.out.println(hashMap.entrySet().size());


    }
}
