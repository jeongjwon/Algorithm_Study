import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; this.next = null; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_2_Add_Two_Numbers {
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode();
        ListNode head = result;

        int sum = 0;
        
        while(l1 != null || l2 != null || sum != 0){
            if(l1 != null){
                sum +=l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val; 
                l2 = l2.next;
            }
            ListNode temp = new ListNode(sum % 10);
            sum /= 10;
            result.next = temp;
            result = result.next;
        }
        
        return head.next;

    }
    public static void main(String[] args) {

       
        ListNode first1 = new ListNode(2);
        ListNode second1 = new ListNode(4);
        ListNode third1 = new ListNode(3);
        first1.next = second1;
        second1.next = third1;
        ListNode l1 = first1;

        ListNode first2 = new ListNode(5);
        ListNode second2 = new ListNode(6);
        ListNode third2 = new ListNode(4);
        first2.next = second2;
        second2.next = third2;
        ListNode l2 = first2;

        ListNode res = addTwoNumbers(l1, l2);
        while(res!= null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
