import java.nio.file.FileSystemAlreadyExistsException;
import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; this.next = null; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_21_Merge_Two_Sorted_Lists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // ListNode result = new ListNode();
        // ListNode head = result;
        
        
        // while(! (list1 == null && list2 == null)){
        //     int val1 = 101, val2=101;

        //     if(list1 != null) val1 = list1.val;
        //     if(list2 != null) val2 = list2.val;
        //     System.out.println(val1 + " " + val2);

        //     ListNode temp = new ListNode();

        //     if(val1 <= val2){
        //         temp.val = val1;
        //         list1 = list1.next;  
        //     }else{
        //        temp.val = val2;
        //        list2 = list2.next;                
        //     }
        //     result.next = temp;
        //     result = result.next;    
        // }
        
        // return head.next;
        System.out.print("mergeTwoLists(l1 : ");
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(t1!=null){
            System.out.print(t1.val+ "->");
            t1 = t1.next;
        }
        System.out.print(",  l2 : ");
        while(t2!=null){
            System.out.print(t2.val+ "->");
            t2 = t2.next;
        }
        System.out.println();

        if(l1 == null) {          
            return l2;
		}
    	if(l2 == null){
           
			return l1;
		} 
    	
    	if(l1.val < l2.val) {
    		l1.next = mergeTwoLists(l1.next, l2);
            System.out.print("리턴값 l1: ");
            while(temp1 != null){
                System.out.print(temp1.val + " ");
                temp1 = temp1.next;
            }
            System.out.println();
    		return l1;
    	}else {
    		l2.next = mergeTwoLists(l1, l2.next);
            System.out.print("리턴값 l2: ");
            while(temp2 != null){
                System.out.print(temp2.val + " ");
                temp2 = temp2.next;
            }
            System.out.println();
    		return l2;

    	}

    }
    public static void main(String[] args) {

        ListNode first1 = new ListNode(1);
        ListNode second1 = new ListNode(2);
        ListNode third1 = new ListNode(4);
        first1.next = second1;
        second1.next = third1;
        ListNode list1 = first1;

        ListNode first2 = new ListNode(1);
        ListNode second2 = new ListNode(3);
        ListNode third2 = new ListNode(4);
        first2.next = second2;
        second2.next = third2;
        ListNode list2 = first2;


       ListNode res = mergeTwoLists(list1, list2);
        while(res!= null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
