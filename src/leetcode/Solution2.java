package src.leetcode;

import src.ListNode;

import java.util.Arrays;

/**
 * 两两交换链表中的节点
 */
class Solution2 {


    /**
     * 倒叙遍历倒是不用翻转了
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null ) {
            return s;
        }
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0){
            //遍历找到第一个空格
            while (i >= 0 && s.charAt(i) != ' ') i--;
            //substring [4,5) 4
            res.append(s.substring(i+1,j+1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j=i;
        }
        return res.toString().trim();
    }
}

