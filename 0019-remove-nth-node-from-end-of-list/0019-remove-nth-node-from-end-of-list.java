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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        
        if(len == n) return head.next;
        
        curr = head;
        n = len - n - 1;
        while(curr.next != null && n != 0) {
            curr = curr.next;
            n--;
        }
        
        if(curr.next != null) {
            curr.next = curr.next.next;
        }
        
        return head;
    }
}