public class Leetcode_92_ReverseLinkedListⅡ{
	public  ListNode reverseBetween(ListNode head, int left, int right) {
    	if(left == right || head == null) return head;
    	//List
////    	List<Integer> list = new ArrayList<>();
////    	while(head != null) {
////    		list.add(head.val);
////    		head = head.next;
////    	}
////
////    	List<Integer> rev = new ArrayList<>();
////    	for(int i = 0 ; i < list.size(); i ++) {
////    		
////    		if(i >= left-1 && i <= right-1) {
////    			rev.add(list.get(i));
////    		}
////    	}
////    	Collections.reverse(rev);
////    	List<Integer> answer = new ArrayList<>();
////    	
////    	int j = 0;
////    	for(int i = 0 ; i < list.size(); i++) {
////    		if( i < left-1 || i > right-1) {
//////    			System.out.println("i : "+i );
////    			answer.add(list.get(i));
////    		}
////    		else {
////   				answer.add(rev.get(j++));
////    			
////    		}
////    	}
//    	ListNode ret = new ListNode();
//    	ListNode r1 = ret;
//    	for(int i = 0 ; i < answer.size(); i++) {
//    		ListNode temp = new ListNode(answer.get(i));
//    		ret.next = temp;
//    		ret = ret.next;
//    	}
//    	return r1.next;
    	
    	//iterative
    	ListNode root = new ListNode(0), start = new ListNode(0);
    	root.next = head;
    	start.next = head;
    	//start, end
    	for(int i = 0 ; i < left-1 ; i++) {
    		start = start.next;
    	}
    	ListNode end = start.next;//3 4 5
    	for(int i = 0 ; i < right - left ; i++) {
			// 2
    		ListNode temp = start.next;
    		start.next = end.next; 
    		end.next = end.next.next;
    		start.next.next = temp;
    	}
    	return root.next;
    	
    }
}