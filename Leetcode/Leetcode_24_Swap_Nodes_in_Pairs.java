import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; this.next = null; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_24_Swap_Nodes_in_Pairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        //1 2 3 4
        ListNode prev = head; //1 2 3 4
        ListNode cur = head.next; // 2 3 4
        ListNode next = head.next.next;// 3 4

        head = cur; //2 3 4
        head.next = prev; //2 1
        head.next.next = swapPairs(next);

        return head;        
        
    }
    public static void main(String[] args) {

       
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        
        first.next = second;
        second.next = third;
        third.next = forth;
        
             

        ListNode res = swapPairs(first);
        while(res!= null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
