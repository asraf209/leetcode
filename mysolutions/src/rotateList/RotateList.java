package rotateList;

public class RotateList {
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
	
	/**
	 * For k <= Size of the list
	 * First make a list n1..n2, where n1 and n2 are (k-1) node apart
	 * Move n2 forward untill they meet the above condition
	 * Move both n1, n2 untill they reach the end point
	 * Then move that seq in the front of head
	 * 
	 * For k > Size of the list
	 * Do (k % Size of the list). This is the actual value of k that we need to consider
	 * Call the above above algorithm with new k value
	 * @param head of the LinkedList
	 * @param k, Number of times we have to rotate the lsit
	 * @return	Rotated LinkedList
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null || head.next==null || k<=0)	return head;
		ListNode n1 = head;
		ListNode n2 = head;
				
		int i=1;
		int count = 0;		
		while(i<k && n2!=null){			
			n2 = n2.next;
			i++;
			count++;
		}
		if(n2==null){
			return rotateRight(head, (k % count));			
		}
		
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
		RotateList obj = new RotateList();
		int[] a = {1, 2, 3};
		ListNode head = obj.makeList(a);
		ListNode retHead = obj.rotateRight(head, 20000);
		while(retHead != null){
			System.out.println(retHead.val);
			retHead = retHead.next;
		}
	}

}
