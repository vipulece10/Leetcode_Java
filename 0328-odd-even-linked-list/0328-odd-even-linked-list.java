/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
            if(head == null)
	   {
		   return null;
	   }
	   
       ListNode oddDummy = new ListNode(0);
       ListNode evenDummy = new ListNode(0);
       ListNode oddDummyCur = oddDummy;
       ListNode evemDummyCur = evenDummy;
       ListNode cur = head;
       int count=1;
       while(cur!=null)
       {
    	   
    	   if(count%2!=0)
    	   {
    		   oddDummyCur.next = cur;
    		   oddDummyCur = oddDummyCur.next;
    		   
    	   }
    	   else {
    		   evemDummyCur.next = cur;
    		   evemDummyCur = evemDummyCur.next;
    	   }
    	   count++;
    	   cur = cur.next;

       }
      oddDummyCur.next = evenDummy.next;
      evemDummyCur.next = null;
      return oddDummy.next;
    }
}