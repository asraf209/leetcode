package rotateList;

public class RotateList {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null || head.next==null || k<=0)	return head;
		ListNode n1 = head;
		ListNode n2 = head;
		
		int i=1;
		while(i<k && n2!=null){
			n2 = n2.next;
			i++;
		}
		if(n2==null)	return head;
		
		ListNode leftTail = null;
		while(n2.next != null){
			leftTail = n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		if(leftTail != null){
			leftTail.next = null;
			n2.next = head;
		}				
		
        return n1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
