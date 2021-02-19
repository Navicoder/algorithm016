package src.leetcode;

import src.ListNode;

/**
 * 两两交换链表中的节点
 */
class Solution1 {
    public static void main(String[] args) {
        ListNode head = ListNode.genNextNode(new int[]{1,2,3,4});
        ListNode listNode = new Solution1().swapPairsDG_Reverse(head);
        System.out.println(listNode);
    }
    public ListNode swapPairsDG_Reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsDG_Reverse(next.next);
        next.next = head;
        //返回链表头结点
        return next;
    }

    public ListNode swapPairsDG_Order(ListNode head) {
        if (head == null || head.next ==null ) {
            return null;
        }
        ListNode nextNode = head.next.next;
        ListNode next =  head.next;
        next.next = head;
        head.next = swapPairsDG_Order(nextNode);
        //返回链表头结点
        return next;
    }
    //遍历 不懂
    public ListNode swapPairs(ListNode head) {
        ListNode pre = ListNode.genNextNode(new int[]{0});

        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}

