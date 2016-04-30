package reorderList;

public class ReorderList {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	/**
	 * This one works in O(n^2)
	 * @param head
	 */
	public void reorderListN2(ListNode head) {
		if(head==null || head.next==null || head.next.next==null)	return;
		ListNode p = head;
		while(p.next!=null && p.next.next!=null){
			ListNode q = p.next;
			ListNode tmp = p;
			while(q.next!=null){				
				q = q.next;
				tmp = tmp.next;
			}
			q.next = p.next;
			p.next = q;
			tmp.next = null;
			p = q.next;			
		}		
    }

	public void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null)	return;
		ListNode p = head;
		ListNode q = head;
		ListNode prevP = p;
		while(q!=null && q.next!=null){
			prevP = p;
			p = p.next;
			q = q.next.next;
		}
		prevP.next = null;
		
		ListNode right = p;
		ListNode left = head;
		right = reverseList(right);
		
		printList(left);
		printList(right);
		
		p = left;
		left = left.next;
		p.next = null;		
		q = right;
		right = right.next;
		q.next = null;
		p.next = q;
		ListNode curr = q;
		while(left!=null){
			p = left;
			q = right;
			left = left.next;
			right = right.next;
			p.next = q;
			q.next = null;
			curr.next = p;
			curr = q;
		}
		if(right!=null)		curr.next = right;
	}
	
	private ListNode reverseList(ListNode head){
		ListNode p = head;
		ListNode q = head.next;
		p.next = null;
		ListNode newH = p;		
		while(q!=null){
			p = q;
			q = q.next;
			
			p.next = newH;
			newH = p;
		}
		return newH;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5};
		ReorderList obj = new ReorderList();
		ListNode head = obj.makeList(a);
		printList(head);
		
		obj.reorderList(head);
		printList(head);
		
		//head = obj.reverseList(head);
		//printList(head);
	}

}
