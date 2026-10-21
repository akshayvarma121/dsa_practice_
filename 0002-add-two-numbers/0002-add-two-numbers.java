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
        // Dummy node to serve as the starting point of the result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        // Continue looping if there are nodes left in either list, OR if there's a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Calculate the new carry for the next iteration (e.g., 18 / 10 = 1)
            carry = sum / 10;
            
            // Create a new node with the last digit of the sum (e.g., 18 % 10 = 8)
            curr.next = new ListNode(sum % 10);
            
            // Move the current pointer forward
            curr = curr.next;
        }
        
        // Return the actual head of the resulting list
        return dummy.next;
    }
}