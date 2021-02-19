package com.chao.week01;

import src.ListNode;

/**
 * @Author wangwenchao
 * @Date 2020/9/13 9:19 下午
 * @Description 合并 合并两个有序链表

将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

 */
public class B_mergeTwoLists {

    /**
     * 迭代
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode node1,ListNode node2) {
        //todo 不能理解 pre 和 preHeadNode 的区别
        ListNode preHeadNode =ListNode.genNextNode(new int[]{-1});
        ListNode pre = preHeadNode;

        while (node1 !=null && node2 !=null){
            if (node1.val <= node2.val) {
                pre.next =node1;
                node1 = node1.next;
            }else{
                pre.next =node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        pre.next = node1==null?node2:node1;

        return preHeadNode.next;
    }

    /**
     * 递归
     *
     * 代码很简洁  https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }




}
