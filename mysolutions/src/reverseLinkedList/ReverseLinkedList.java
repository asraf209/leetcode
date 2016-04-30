package reverseLinkedList;

import reorderList.ReorderList;

public class ReverseLinkedList {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5};
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode head = obj.makeList(a);
		printList(head);
				
	}

}
