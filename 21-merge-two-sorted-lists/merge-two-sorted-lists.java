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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 =list1;
        ListNode h2=list2;
        ListNode head=null,tail=null;
        while(h1!=null || h2!=null){
            ListNode nodecpy=null;
            if(h1!=null && h2!=null){
                if(h1.val<=h2.val){
                    nodecpy=h1;
                    h1=h1.next;

                }
                else{
                    nodecpy=h2;
                    h2=h2.next;
                }
            }
            else if(h1!=null){
              nodecpy=h1;
              h1=h1.next;

            }
            else{
                nodecpy=h2;
                h2=h2.next;
            }
            tail=insert(tail,nodecpy.val);
            if(head==null){
                head=tail;
            }
        }

        return head;
        
    }
    public ListNode insert(ListNode tail,int data) {
        ListNode ntbi = new ListNode(data, null);
        
        if (tail != null) {
            tail.next = ntbi;
        }
        
        return ntbi;
    }
}