/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int int1;
        int int2;
        int sum = 0;
        int carry = 0;
        ListNode sumNode = new ListNode(0);
        ListNode l3 = sumNode;
        while(true) {
            int1 = (l1==null) ? 0 : l1.val; // 2; 4; 3
            int2 = (l2==null) ? 0 : l2.val; // 5; 6; 4
            sum = int1 + int2 + carry;  // 2 + 5 + 0; 10; 8
            sumNode.val = sum % 10; // 7; 0; 8
            if(sum >= 10) {
                carry = 1; // 0; 1; 0
            } else {
                carry = 0;
            }
            // go to next node
            l1 = (l1==null) ? null : l1.next; // 4; 3; null
            l2 = (l2==null) ? null : l2.next; // 6; 4; null
            
            // if either node has is not null, then prepare for next iter.
            if(l1!=null || l2!=null) {
                sumNode.next = new ListNode(0); // 7:0:8:done;
                sumNode = sumNode.next;
            } else {
                // if both null, then just take care of carry.
                if(carry > 0) { // false
                    sumNode.next = new ListNode(carry); // done;
                }
                break;
            }
        }
        return l3;
    }
}
