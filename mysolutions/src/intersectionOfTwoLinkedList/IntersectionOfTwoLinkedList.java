package intersectionOfTwoLinkedList;

public class IntersectionOfTwoLinkedList {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
		       next = null;
		 }
	}
	
	public ListNode makeList(int[] a){
		ListNode head = null;
		ListNode p = null;
		for(int n : a){
			if(head == null){
				head = new ListNode(n);
				p = head;
			}
			else{
				p.next = new ListNode(n);
				p = p.next;
			}
		}
		return head;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)	return null;
		
		// COmpute size of list A
		int sizeA = 0;
		ListNode a = headA;
		while(a!=null){
			sizeA ++;
			a = a.next;
		}
		
		// Compute size of list B
		int sizeB = 0;
		ListNode b = headB;
		while(b!=null){
			sizeB ++;
			b = b.next;
		}
		
		// Move head pointer of Big List untill they become same size
		a = headA;
		b = headB;
		if(sizeA > sizeB){
			while(sizeA != sizeB){
				a = a.next;
				sizeA --;
			}
		}
		else if(sizeB > sizeA){
			while(sizeB != sizeA){
				b = b.next;
				sizeB --;
			}
		}
			
		// Now move both pointer at the same speed. They will meet eventually 
		while(a!=b){
			a = a.next;
			b = b.next;
		}
		
		return a;
    }
	
	public static void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();
		
		int[] a = {1,2,3,4,5};
		ListNode headA = obj.makeList(a);
		printList(headA);
		
		int[] b = {6,7,8,3,4,5};
		ListNode headB = obj.makeList(b);
		printList(headB);
		
		ListNode comm = obj.getIntersectionNode(headA, headB);
		printList(comm);
	}

}
