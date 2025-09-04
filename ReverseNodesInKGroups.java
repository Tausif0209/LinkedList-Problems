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
    public ListNode reverseKGroup(ListNode head, int k) {
    ListNode temp=head;
       int count=0;
       while(count<k){
           count++;
           temp=temp.next;
       }
       ListNode prevHead=head;
       ListNode startNode=temp;
       head=reverse(null,head,temp);
       if(temp==null) return head;
       count++;
       temp=temp.next;
       while(temp!=null){
           if(count%k==0) {
               prevHead.next=reverse(null,startNode,temp);
               prevHead=startNode;
               startNode=temp;
           }
           count++;
           temp=temp.next;
       }
       if(count%k==0) prevHead.next=reverse(null,startNode,temp);
       else prevHead.next=startNode;
       return head;
        
    }
    private ListNode reverse(ListNode prev,ListNode currNode,ListNode endNode){
        if(currNode==endNode) return prev;
        ListNode temp=currNode.next;
        currNode.next=prev;
        return reverse(currNode,temp,endNode);
    }   
}