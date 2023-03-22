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
class Leetcode_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //iterative method
    	ListNode answer = new ListNode();
        ListNode head = answer;
        
       while(!(l1 == null && l2 == null)) {
    		int val1 = 101 , val2 = 101;
        	
    		if(l1 != null) val1 = l1.val;
    		if(l2 != null) val2 = l2.val;
    		System.out.println(val1 + " , " +val2);
    		ListNode temp = new ListNode();
    		
    		if(val1 >= val2) {
    			temp.val = val2;
    			l2 = l2.next;
    		}
    		else {
    			temp.val = val1;
    			l1 = l1.next;
    		}
    		answer.next = temp;
    		answer = answer.next;
    	}
        // return head.next;
        
        //recrusive method
        if(l1 == null) {
			return l2;
		}
    	if(l2 == null){
			return l1;
		} 
    	
    	if(l1.val < l2.val) {
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;
    	}else {
    		l2.next = mergeTwoLists(l1, l2.next);
    		return l2;

    	}
    }
	public static void main(String[] args){

	}
}
