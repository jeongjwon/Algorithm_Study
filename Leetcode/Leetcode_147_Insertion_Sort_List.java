
public class Leetcode_147_Insertion_Sort_List {
    public static ListNode insertionSortList(ListNode head) {
        // 	for(int i = 1; i < arr.length ; i++){
    	// int target = arr[i];
        // int j = i-1;
        // for(j = i-1 ; j >= 0 && target < arr[j]; j--){
        // 	arr[j+1] = arr[j];
        // }
        // arr[j] = target;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;//4 2 1 3
        ListNode prev = dummy; //0
        ListNode next = null;

        //4 2 1 3 

        while(cur != null){

           next = cur.next; // 2 1 3 , //1 3 
           System.out.println(prev.val);
           while(prev.next != null && prev.next.val < cur.val){
            prev = prev.next;
            
           }

           cur.next = prev.next; // 4 -> null , 2-> null
           prev.next = cur; // 0 -> 4 2 1 3 , 4-> 2 1 3
           prev = dummy; // 0 초기화
           cur = next; // 2 1 3 , 1 3

        }

        return dummy.next;
    
    }
    public static void main(String[] args){
         ListNode node = new ListNode(4,
             new ListNode(2, new ListNode(1, new ListNode(3) )));
        ListNode answer = insertionSortList(node);
        while(answer != null){
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}