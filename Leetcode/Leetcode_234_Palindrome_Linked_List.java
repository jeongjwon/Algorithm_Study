import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Leetcode_234_Palindrome_Linked_List {
    
    public static boolean isPalindrome(ListNode head) {
        //1. forward 와 backward 분리시킴
        ListNode temp = head;
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        List<Integer> forward = new LinkedList<>();
        List<Integer> backward = new LinkedList<>();

        for(int i = 0 ; i < count/2 ; i++){
            forward.add(temp.val);
            temp = temp.next;
        }

        if(count % 2 == 0){
            for(int i = 0 ; i < count/2 ; i++){
                backward.add(temp.val);
                temp = temp.next;
            }
        }else{
            temp = temp.next;
            for(int i = 0 ; i < count/2 ; i++){
                backward.add(temp.val);
                temp = temp.next;
            }
        }
        System.out.println(forward + " / " +backward);
        for(int i = 0 ; i < forward.size() ; i++){
            if(forward.get(i) != backward.get(backward.size()-1-i)){
                return false;
            }
        }
        return true;

        //2. 한번에
        // List<Integer> list = new LinkedList<>();
        // list.add(head.val);

        // while(head.next!=null){
            
        //     head = head.next;
        //     list.add(head.val);
        // }
        // for(int i = 0 ; i < list.size() / 2; i++){
        //     // if(list.get(i) != list.get(list.size()-1-i)){
        //     //     return false;
        //     // }
        //     if(!list.get(i).equals(list.get(list.size()-1-i))){
        //         return false;
        //     }
        // }
        // return true;
    }

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode forth = new ListNode(1);
        first.next = second;
        second.next = third;
        third.next = forth;

       System.out.println(isPalindrome(first));

    }
}
