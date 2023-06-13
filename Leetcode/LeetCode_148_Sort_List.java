public class Leetcode_148_Sort_List {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        // 쉬운 방법은 val 만 골라내서 List로 정렬한 다음 ListNode 로 만들어주기

        
//         ListNode result = head;
//  //4 2 1 3
//         while(head.next != null){
//             ListNode cur = head; //4
//             ListNode next = head.next; //2

//             if(next.val < cur.val){//현재값이 크다면 바꾸어 줘야함
//                 int temp = cur.val;//4
//                 cur.val = next.val;//
//                 next.val = temp;
                

//             }
//             head = head.next;
//         }
//4 2 1 3
// slow 4 2 1 3
// fast 4 2 1 3

        ListNode prev = null, slow = head, fast = head;
   
        while(fast != null && fast.next != null){
            prev = slow; // 4 
            slow = slow.next; // 2
            fast = fast.next.next; //1
            // System.out.println(prev.val + " " + slow.val + " " + fast.val);
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);

    }
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
             cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }

        return dummy.next;
    }
    
    public static void main(String[] args){

        ListNode node = new ListNode(4,
             new ListNode(2, new ListNode(1, new ListNode(3) )));
        ListNode answer = sortList(node);
        while(answer != null){
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}
