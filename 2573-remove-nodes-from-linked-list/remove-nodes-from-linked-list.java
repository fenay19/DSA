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
    public ListNode removeNodes(ListNode head) {
      ListNode curr=head;
    Stack<ListNode>st=new Stack<>();
   
    while(curr!=null){
    while(!st.isEmpty() && st.peek().val<curr.val){
        st.pop();
    }
st.push(curr);
curr=curr.next;

    }
    ListNode nxt=null;
    while(!st.isEmpty()){
        ListNode cu=st.pop();
        cu.next=nxt;
        nxt=cu;
    }
    return nxt;

    }
}