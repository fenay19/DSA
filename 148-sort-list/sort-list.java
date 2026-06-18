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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode mid=findmid(head);

        ListNode l=head;
        ListNode r=mid.next;
        mid.next=null;
        ListNode lr=sortList(l);
        ListNode rr=sortList(r);

        return merge(lr,rr);
    }

    public ListNode findmid(ListNode head){
 ListNode s=head;
 ListNode f=head.next;
 while(f!=null && f.next!=null){
s=s.next;
f=f.next.next;


 }
 return s;

    }
    public ListNode merge(ListNode l,ListNode r){

ListNode dum=new ListNode(-1);
ListNode tmp=dum;

while(l!=null && r!=null){
if(l.val<=r.val){
tmp.next=l;
l=l.next;

}
else{
    tmp.next=r;
    r=r.next;
}
tmp=tmp.next;


}
 if (l != null) {
        tmp.next = l;
    }

    if (r != null) {
        tmp.next = r;
    }
return dum.next;
    }
}