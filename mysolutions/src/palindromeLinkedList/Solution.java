package palindromeLinkedList;

/**
 * 2nd approach: 
 * 1. Find the mid point using slow/fast pointer
 * 2. While traversing, put values of each slow node into a Stack
 * 3. After getting the mid point, forward fast to the end by 1x speed, till null
 * 4. While doing Step 3, pop elements from Stack and compare with fast node value
 * 5. At any point, if they mismatch, return false
 * 6. After fast become null, Stack should be empty. Return true if it is so, else return false 
 */


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
		if(fast!=null && fast.next==null)		// Odd number of items
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
		while(leftHead != rightHead && rightPointer!=null){
			if(leftHead.val != rightPointer.val)	return false;
			leftHead = leftHead.next;
			rightPointer = rightPointer.next;
		}		
		return true;
    }
	
	public ListNode makeLinkedList(int[] a){
		ListNode head = null;
		ListNode tail = head;
		for(int n : a){
			if(head ==null){
				head = new ListNode(n);
				tail = head;
			}
			else{
				tail.next = new ListNode(n);
				tail = tail.next;
			}
		}
		return head;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a={0,0};
		Solution obj = new Solution();
		ListNode head = obj.makeLinkedList(a);
		System.out.println(obj.isPalindrome(head));
	}

}
