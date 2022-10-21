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

/**
https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration 
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer != null){
            ListNode node = pointer;
            for(int i=1;i<=k && node != null;i++){
                node = node.next;
            }
            if(node == null)
                break;
            ListNode prev = pointer;
            ListNode curr = pointer.next;
            ListNode next = null;
            for(int i =0;i<k;i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            ListNode temp = pointer.next;
            temp.next = curr;
            pointer.next = prev;
            pointer = temp;
        }
        return dummy.next;
    }
}