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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode lar=new ListNode(0);
        ListNode sml=small;
        ListNode large=lar;
        ListNode temp=head;
        while(temp!=null){

            if(temp.val>=x){
                large.next=temp;
                large=large.next;
            }
            else{

                sml.next=temp;
                sml=sml.next;
            }
            temp=temp.next;


        }
       large.next=null;
        sml.next=lar.next;

        return small.next;
    }
}