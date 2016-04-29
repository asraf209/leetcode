package partitionList;

import removeNthNode.RemoveNthNode.ListNode;

public class partitionList {
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
	
	public static void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
	
	public ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)	return head;
		
		ListNode leftHead = null;
		ListNode leftTail = null;		
		ListNode rightHead = null;
		ListNode rightTail = null;
		
		ListNode p = head;
		
		while(p!=null){
			if(p.val < x)	addToList(leftHead, leftTail, p);
			else	addToList(rightHead, rightTail, p);
		}
		
		leftTail.next = rightHead;		
		
		return leftHead;
    }
	
	public void addToList(ListNode head, ListNode tail, ListNode p){
		if(head == null){
			head = p;
			tail = head;
		}
		else{
			tail.next = p;
			tail = tail.next;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 4, 3, 2, 5, 2};
		
	}

}
