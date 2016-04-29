package partitionList;

public class PartitionList {
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
	
	public ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)	return head;
		
		ListNode leftHead = null;
		ListNode leftTail = null;		
		ListNode rightHead = null;
		ListNode rightTail = null;
		
		ListNode p = head;
		
		while(p!=null){
			if(p.val < x){
				if(leftHead==null){
					leftHead = p;
					leftTail = leftHead;
				}
				else{
					leftTail.next = p;
					leftTail = leftTail.next;
				}				
			}							
			else{
				if(rightHead==null){
					rightHead = p;
					rightTail = rightHead;
				}
				else{
					rightTail.next = p;
					rightTail = rightTail.next;
				}
			}
				
			p = p.next;
		}
	
		if(rightTail!=null)	rightTail.next = null;
		if(leftTail!=null)	leftTail.next = rightHead;		
		
		if(leftHead!=null)	return leftHead;
		else return rightHead;
    }
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 4, 3, 2, 5, 2};
		PartitionList obj = new PartitionList();
		ListNode head = obj.makeList(a);
		printList(head);
		
		head = obj.partition(head, 3);
		printList(head);
	}

}
