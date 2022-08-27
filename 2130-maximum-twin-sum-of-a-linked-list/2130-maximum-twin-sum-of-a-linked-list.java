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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode  curr = head;
        int sum = Integer.MIN_VALUE;
        // to find the middle of the list
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        System.out.print(slow.val);
        
        ListNode middle = slow;
        ListNode end = reverseList(middle);
        System.out.print(end.val);
      //  slow.next = end;
        while(end!=null){
            sum = Math.max(sum,curr.val + end.val );
            curr = curr.next;
            end = end.next;
        }
        return sum;
    }
    
    //to reverse the list
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}