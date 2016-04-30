package reverseLinkedListII;

public class ReverseLinkedListII {
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
	public ListNode reverseList(ListNode m, ListNode n, ListNode nextN) {
		if(m == null || m.next == null)	return m;		
		
		ListNode prev = m;
		ListNode curr = m.next;
		prev.next = nextN;
		ListNode newHead = prev;
		
		while(curr!=nextN){
			prev = curr;
			curr = curr.next;
			prev.next = newHead;
			newHead = prev;
		}
		
		return newHead;
    }
	
	/**
	 * Find two node points for m and n
	 * Reverse that portion
	 * Find prev node of m
	 * Link the next of prev m to the head of reversed list
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null || m==n)	return head;
		int i=1;		
		ListNode curr = head;
		ListNode prevM = null;
		
		while(i!=m){
			prevM = curr;
			curr = curr.next;
			i++;
		}
		ListNode nodeM = curr;
		
		while(i!=n){
			curr = curr.next;
			i++;
		}
		ListNode nodeN = curr;
		
		ListNode revHead = reverseList(nodeM, nodeN, nodeN.next);
		if(prevM!=null)	prevM.next = revHead;
		
		if(m>1)	return head;
		else return revHead;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1, 2, 3, 4, 5};
		int[] a = {3, 5};
		ReverseLinkedListII obj = new ReverseLinkedListII();
		ListNode head = obj.makeList(a);
		printList(head);
				
		head = obj.reverseBetween(head, 1, 2);
		printList(head);
	}
}
