package addTwoNumbers;

public class Solution {
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	/**
	 * Time: O(n); Space: O(1)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null && l2 == null)	return null;
		if(l1 == null)	return l2;
		if(l2 == null)	return l1;
		
		int sum = 0;
		int carry = 0;
		
		ListNode n1 = l1;
		ListNode n2 = l2;
		ListNode res = null;
		ListNode tmp = res;
		
		while(n1!=null || n2!=null){
			if(n1!=null && n2!=null){
				sum = (n1.val + n2.val + carry)%10;
				carry = (n1.val + n2.val + carry)/10;
				if(res==null){
					res = new ListNode(sum);
					tmp = res;
				}
				else{
					tmp.next = new ListNode(sum);
					tmp = tmp.next;
				}
				n1 = n1.next;
				n2 = n2.next;
			}
			else if(n1!=null){
				sum = (n1.val + carry)%10;
				carry = (n1.val + carry)/10;
				tmp.next = new ListNode(sum);
				tmp = tmp.next;
				n1 = n1.next;
			}
			else{
				sum = (n2.val + carry)%10;
				carry = (n2.val + carry)/10;
				tmp.next = new ListNode(sum);
				tmp = tmp.next;
				n2 = n2.next;
			}
			
		}
		
		if(carry>0)	tmp.next = new ListNode(carry);
		
        return res;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
