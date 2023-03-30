public class Leetcode_328_Odd_Even_Linked_List {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;//1 2 3 4 5
        ListNode even = head.next;// 2 3 4 5
        ListNode evenStart = even;
        ListNode result = odd;

        while(even != null && even.next != null){
            //1 2 3 4 5
           
            odd.next = odd.next.next; //3 4 5
            even.next= even.next.next;//4 5

            odd = odd.next; //1 3 4 5
            even = even.next;
        }
        odd.next = evenStart;

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
             

        ListNode res = oddEvenList(first);
        while(res!= null){
            System.out.println(res.val);
            res = res.next;
        }

    }
    
}
