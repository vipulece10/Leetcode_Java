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
    public ListNode partition(ListNode head, int x) {
        ListNode firstList = new ListNode(-1);
        ListNode firstCurr = firstList;
        ListNode secondList = new ListNode(-1);
        ListNode secondCurr = secondList;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val < x){
                firstCurr.next = curr;
                firstCurr= firstCurr.next;
            }else{
                secondCurr.next = curr;
                secondCurr= secondCurr.next;
            }
            curr = curr.next;
        }
        secondCurr.next = null;
        firstCurr.next = secondList.next;
        
        return firstList.next;
    }
}