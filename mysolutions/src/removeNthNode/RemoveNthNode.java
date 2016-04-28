package removeNthNode;

public class RemoveNthNode {
	public class ListNode {
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
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null || n<1)	return head;
		ListNode p1 = head;
		ListNode p2 = head;	
		
		/**
		 * Make a sublist n1...n2, n node apart
		 */
		int i=1;
		while(i<n && p2 != null){
			p2 = p2.next;
			i++;
		}
		
		// n > Size of the list
		if(p2==null)	return head.next;	// LeetCode wants to remove head in this case. Dont know why
		
		/**
		 * Move the sublist till the end
		 */
		ListNode leftTail = null;
		while(p2.next != null){
			leftTail = p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		
		if(p1 == head)	head = head.next;	// nth node is the head
		else if(leftTail!=null)	leftTail.next = p1.next;
		
		return head;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3};
		RemoveNthNode obj = new RemoveNthNode();
		ListNode head = obj.makeList(a);
		ListNode retHead = obj.removeNthFromEnd(head, 3);
		while(retHead != null){
			System.out.println(retHead.val);
			retHead = retHead.next;
		}
	}

}
