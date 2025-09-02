class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; 
    }}
public class SwapNodes {
  public ListNode swapNodes(ListNode head, int k) {
        int len=len(head);
        if(len==1  || (len%2!=0 && k==(len+1)/2)) return head;
        ListNode temp;
        if(k==1 || k==len){
            temp=head;
            ListNode prev=null;
            while(temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            prev.next=head;
            temp.next=head.next;
            head.next=null;
            return temp;
        }
        ListNode[] fromStart=findNodes(head,k-1);
        ListNode[] fromLast=findNodes(head,len-k);
        fromStart[0].next=fromLast[1];
        fromLast[0].next=fromStart[1];
        
        temp=fromLast[1].next;
        fromLast[1].next=fromStart[1].next;
        fromStart[1].next=temp;
        return head;
    }
    private int len(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        } return len;
    }
    private ListNode[] findNodes(ListNode head,int index){
        int i=0;
        ListNode prev=null;
        while(i!=index){
            prev=head;
            head=head.next;
            i++;
        } return new ListNode[]{prev,head};
    }
}
