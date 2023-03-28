import java.util.*;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Leetcode_206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {

		ListNode answer = new ListNode();
		ListNode res = answer;
		List<Integer> list = new ArrayList<>();

		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		for (int i = 0; i < list.size(); i++) {
			ListNode temp = new ListNode();
			temp.val = list.get(list.size() - 1 - i);

			answer.next = temp;
			answer = answer.next;
		}

		// return res.next;

		// iterative
		ListNode newNode = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = newNode;
			newNode = head;
			head = next;
		}
		return newNode;

	}
	
}
