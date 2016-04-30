package reverseLinkedList;

public class ReverseLinkedList {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public ListNode makeList(int[] a){
		ListNode head=null, curr= null;
		for(int n : a){
			if(head==null){
				head = new ListNode(n);
				curr = head;
			}
			else{
				curr.next = new ListNode(n);
				curr = curr.next;
			}
		}		
		return head;
	}
	
	public static void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	/**
	 * Iterative algorithm.
	 * Take one node from the list
	 * Make next ptr to null
	 * Add the node to the new list
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)	return head;
		
		ListNode prev = head;
		ListNode curr = head.next;
		prev.next = null;
		ListNode newHead = prev;
		
		while(curr!=null){
			prev = curr;
			curr = curr.next;
			prev.next = newHead;
			newHead = prev;
		}
		
		return newHead;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5};
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode head = obj.makeList(a);
		printList(head);
				
		head = obj.reverseList(head);
		printList(head);
	}
}
