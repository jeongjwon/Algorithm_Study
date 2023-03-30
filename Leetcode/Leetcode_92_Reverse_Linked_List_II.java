public class Leetcode_92_Reverse_Linked_List_II {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode start = head;
        ListNode result = start;

        //start : left 전까지의 노드
       for(int i = 0 ; i < left-1 ;i++){
            start = start.next;
        }

    //start 2
        
        
        ListNode newNode = null;
        // start.next = newNode;
        
        for(int i = 0 ; i <= right-left ; i++){
            ListNode next = start.next;// 
            start.next = newNode;//2 -> null // 3-> 2-> null
            newNode = start; //2 null// 
            start = next; //3 4 5
           

        }
        
        ListNode end = start;
        result.next = newNode;

        while(newNode.next!=null){
            newNode = newNode.next;
        }
        newNode.next = end;
       
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
