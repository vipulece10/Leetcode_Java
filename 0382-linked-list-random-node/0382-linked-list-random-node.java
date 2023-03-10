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
    List <Integer> arr;
    ListNode curr;
    public Solution(ListNode head) {
        arr = new ArrayList<>();
        curr = head;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        
    }
    
    public int getRandom() {
        Random generator = new Random();
        int num = generator.nextInt(arr.size());
        return arr.get(num);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */