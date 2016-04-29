package reorderList;

public class ReorderList {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public void reorderList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null)	return;
		ListNode p = head;
		while(p.next==head || p.next.next!=head){
			ListNode q = p.next;
			while(q.next!=null)	q = q.next;
			q.next = p.next;
			p.next = q;
			p = q.next;
		}
		
		if(p.next==head)	p.next = null;
		else if(p.next.next==head)	p.next.next = null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
