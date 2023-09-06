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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int n = 0;
        
        while(curr != null){
            n++;
            curr = curr.next;
        }
        
        int size = n/k; int rem = n%k;
        System.out.println(size + " "+ rem); 
        
        ListNode [] ans = new ListNode[k];
        ListNode start = head;
        
        for(int i = 0;i<k;i++){
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            for(int j =0; j< size + (i<rem ? 1 : 0) ;j++){
                if(start!=null){
                prev.next = new ListNode(start.val);
                prev = prev.next;
                start = start.next;
                }
            }
            ans[i] = dummy.next;
        }
        return ans;
    }
}