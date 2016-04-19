package palindromeLinkedList;

public class Solution {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	@SuppressWarnings("null")
	public boolean isPalindrome(ListNode head) {
		if(head==null)	return false;
		if(head.next==null)	return true;
		
		// Find the middle element to separate into two list
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null || fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}		
		if(fast.next==null)		// Odd number of items
			slow = slow.next;	
		
		
		return false;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
