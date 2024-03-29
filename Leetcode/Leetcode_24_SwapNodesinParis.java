/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Leetcode_24_SwapNodesinParis {
    public ListNode swapPairs(ListNode head) {
        
        
        if(head == null || head.next == null) return head;
        
        ListNode pre = new ListNode(0);
        ListNode p = head; //1234
        ListNode ret = head.next; //234
        
        while(p != null && p.next != null){
            ListNode temp = p.next; //234
            p.next = temp.next; //1 34
            temp.next = p;//2 134
            
            pre.next = temp; //2134
            pre = p; //134
            p = p.next;
             
        }
        return ret;
        
        
    }
}
