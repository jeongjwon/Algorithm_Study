import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; this.next = null; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_206_Reverse_Linked_List {
    public static ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        ListNode answer = result;
        Stack<Integer> stack = new Stack<>();

        while(head != null){
            stack.push(head.val);
            head = head.next;
        }

        while(!stack.isEmpty()){
            int val = stack.pop();
            
            ListNode temp = new ListNode();
            temp.val = val;
            result.next = temp;
            result = result.next;
        }

        return answer.next;


        
    }
    public static void main(String[] args) {

       
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
             

        ListNode res = reverseList(first);
        while(res!= null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}


// 1 2 3 4 5
// next = head.next 2 3 4 5 | 3 4 5 | 4 5 | 5 | null
// head.next = newNode null | 1 null | 2 1 null | 3 2 1 null | 4 3 2 1 null
// newNode = head; 1 null | 2 1 null | 3 2 1 null | 4 3 2 1 null 5 4 3 2 1 null
// head = next; 2 3 4 5 | 3 4 5 | 4 5 | 5 | null