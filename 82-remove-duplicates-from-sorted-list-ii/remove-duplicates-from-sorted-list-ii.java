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
    public ListNode deleteDuplicates(ListNode head) {
     ListNode dum=new ListNode(0);
     dum.next=head;
     ListNode curr=head;
     ListNode prev=dum;
     while(curr!=null){

if(curr.next!=null && curr.val==curr.next.val){

int nd=curr.val;

while(curr!=null && curr.val==nd){
    curr=curr.next;

}
prev.next=curr;

}
else{
    prev=curr;
    curr=curr.next;
}



     }
     return dum.next;
    }
}