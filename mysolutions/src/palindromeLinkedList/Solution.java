package palindromeLinkedList;

import org.w3c.dom.NodeList;

public class Solution {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {		
		if(head==null || head.next==null)	return true;
		
		// Find middle element to separate into two list
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}		
		if(fast.next==null)		// Odd number of items
			slow = slow.next;	
		
		// Make two list
		ListNode leftHead = head;
		ListNode rightHead = null;
		ListNode rightTail = rightHead;
		
		// Reverse the right half and make a LinkedList
		while(slow!=null){
			ListNode tmp = slow;
			slow = slow.next;
			tmp.next = null;
			
			if(rightHead == null){
				rightHead = tmp;
				rightTail = tmp;
			}
			else{
				tmp.next = rightHead;
				rightHead = tmp;
			}			
		}
		
		// Compare the two LinkedList to find if it is palindrome or not
		ListNode rightPointer = rightHead;
		while(leftHead.next!=rightHead || leftHead.next.next!=rightHead){
			if(leftHead.val != rightPointer.val)	return false;
			leftHead = leftHead.next;
			rightPointer = rightPointer.next;
		}		
		return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
