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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        // ListNode dummy = new ListNode(-1);
        // ListNode prev = dummy;
        
        while(curr1 != null){
            st1.add(curr1.val);
            curr1 = curr1.next;
        }
        
        while(curr2 != null){
            st2.add(curr2.val);
            curr2 = curr2.next;
        }
        
        int carry = 0;
        ListNode ans = null;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int sum = 0;
            int x= st1.isEmpty() != true ? st1.pop() : 0;
            int y = st2.isEmpty() != true ? st2.pop() : 0;
            
            sum = x + y + carry;
            //prev.next = new ListNode(sum % 10);
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = ans;
            carry = sum/10;
            ans = newNode;
        }
        
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;
        }
        
        return ans;
    }
}