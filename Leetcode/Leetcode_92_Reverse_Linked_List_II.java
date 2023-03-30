public class Leetcode_92_Reverse_Linked_List_II {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode start = head;
        ListNode result = start;
        while(count < left){
            start = start.next;
            count++;
        }

        ListNode reverse = start.next;
        start.next = reverse;

        ListNode newNode = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = newNode;
			newNode = head;
			head = next;
		}
		return newNode;
        while(count < right){
            ListNode next = 
        }
        return result;
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
             

        ListNode res = reverseBetween(first,2,4);
        while(res!= null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
