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
    public int len(ListNode head){
        int counter = 0;
        while(head!=null){
            counter++;
            head = head.next;
        }
        return counter;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = len(head);
        int groups = n/k;
        ListNode prevhead = null;
        ListNode currhead = head;
        ListNode ansNode = null;
        for(int i =0;i<groups;i++){
            ListNode prev = null;
            ListNode curr = currhead;
            ListNode nextNode = null;
            for(int j =0;j<k;j++){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            if(prevhead == null ){
                ansNode = prev;
            }else{
                prevhead.next = prev;

            }
            prevhead = currhead;
            currhead = curr;
        }
        prevhead.next = currhead;
        return ansNode;

    }
}