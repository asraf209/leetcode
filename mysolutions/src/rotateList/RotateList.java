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
	
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null || head.next==null || k<=0)	return head;
		ListNode n1 = head;
		ListNode n2 = head;
				
		int i=1;
		ListNode tail = null;
		while(i<k && n2!=null){
			tail = n2;
			n2 = n2.next;
			i++;
		}
		if(n2==null){
			ListNode h = new ListNode(tail.val);
			h.next = head;
			tail = null;
			return h;
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
		int[] a = {1, 2};
		ListNode head = obj.makeList(a);
		ListNode retHead = obj.rotateRight(head, 2);
		while(retHead != null){
			System.out.println(retHead.val);
			retHead = retHead.next;
		}
	}

}
