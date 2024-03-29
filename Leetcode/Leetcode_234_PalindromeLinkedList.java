import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; this.next = null; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_234_PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {

    	int count = 0;
    	ListNode temp = head;

    	while(head != null) {
    		count++;
    		head = head.next;
    	}
    	

    	
    	int n = count;
    	List<Integer> forward = new ArrayList<>();
    	List<Integer> reverse = new ArrayList<>();


    	for(int i = 0 ; i < count/2 ; i++) {
    		forward.add(temp.val);
    		temp = temp.next;
    	}
    	if(count%2 == 1) {
    		temp = temp.next;
    		for(int i = 0 ; i < count/2 ; i++) { 
    	
    			reverse.add(temp.val);
    			temp = temp.next;
    		}
    	}
    	else {
    		for(int i = 0 ; i < count/2 ; i++) {
    			reverse.add(temp.val);
    			temp = temp.next;
    		}
    	}
    	for(int i = 0 ; i < n/2 ; i ++) {
    		if(forward.get(i) != reverse.get(reverse.size() - 1 - i)) return false;
    		
//    		System.out.println(forward.get(i) + " , " + reverse.get(i));
    	}
    	return true;
    }
}
