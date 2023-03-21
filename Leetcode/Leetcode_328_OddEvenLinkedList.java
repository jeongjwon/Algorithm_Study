class Solution {
    public ListNode oddEvenList(ListNode head) {
     	if(head == null) return null; //[]일 경우 -> []
	    else {
            ListNode odd = head;
            ListNode even = head.next;
        
            ListNode temp = even;
            ListNode newNode = odd;
        
            while(even != null && even.next != null){
                //아직 종료 조건에 대해 잘 모르겠음
                odd.next = odd.next.next;
                even.next = even.next.next;
            
                odd = odd.next;
                even = even.next;
            }
        
            odd.next = temp;
            return newNode; //or return head;
		        
        }
        
        
    }
}
