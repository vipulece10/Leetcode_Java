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
    public ListNode modifiedList(int[] nums, ListNode head) {
        /*
        nums = [1,2,3], head = [1,2,3,4,5]
             dummy->1-> 2-> 3->4->5
                  prev curr
        */
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode curr = head;
        
        while(curr != null){
            if(set.contains(curr.val)){
                prev.next = curr.next;
               // prev = prev.next;
            }
            else{
                prev = curr;
            }
            
            curr = curr.next;
        }
        return dummy.next;
        
    }
}