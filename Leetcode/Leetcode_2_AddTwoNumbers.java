public class Leetcode_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
    	ListNode answer = ret;
    	// boolean up = false;
    	int sum = 0;

    	while(l1 != null || l2 != null || sum != 0) {
    		
    		if(l1 != null) { sum += l1.val; l1 = l1.next; }
    		if(l2 != null) { sum += l2.val; l2 = l2.next; }
    		
    		// sum = up ? sum+1 : sum;

			
    		
    		
    		ListNode temp = new ListNode(sum%10);
    		sum /=10;
    		ret.next = temp;
    		ret = ret.next;
    		
			
    		
    	}
    	return answer.next;
    }
}
