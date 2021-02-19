package src;

import java.util.Arrays;

public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


      public static ListNode genNextNode(int[] vals){
            if (vals == null || vals.length == 0) {
                  return null;
            }
            return new ListNode(vals[0],genNextNode(Arrays.copyOfRange(vals,1,vals.length)));
      }


      @Override
      public String toString(){
            String S="-->";
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp !=null){
                  sb.append(temp.val).append(S);
                  temp = temp.next;
            }
            String s = sb.toString();
            if (s.endsWith(S)) {
                  s = s.substring(0,s.lastIndexOf(S));
            }
            return s;
      }

      public static void main(String[] args) {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
            System.out.println(head);

            ListNode listNode = genNextNode(new int[]{1, 2, 3, 4});
            System.out.println(listNode);
      }
}