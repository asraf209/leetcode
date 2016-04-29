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
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
