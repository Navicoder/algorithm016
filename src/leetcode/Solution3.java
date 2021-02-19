package src.leetcode;

import src.ListNode;

/**
 * 合并两个排序的链表
 */
class Solution3 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.genNextNode(new int[]{1,3,6,7,8,9,10});
        ListNode l2 = ListNode.genNextNode(new int[]{2,3,4});
        ListNode listNode = new Solution3().mergeTwoLists2(l1, l2);
        System.out.println(listNode);
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dum = ListNode.genNextNode(new int[]{0});

        ListNode cur = dum;
        while (l1 != null && l2 !=null){
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 =l1.next;
            }else{
                cur.next =l2;
                l2 =l2.next;
            }
            cur =cur.next;
        }
        cur.next = l1 !=null ?l1:l2;

        return dum.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = ListNode.genNextNode(new int[]{0}), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
