
public class LengthOfLoop {
  public int lengthOfLoop(Node head) {
      return cycleLength(head);
    }
    private int cycleLength(Node head){
        if(head.next==null || head.next.next==null) return 0;
        Node slowPointer=head.next;
        Node fastPointer=head.next.next;
        while(fastPointer!=slowPointer && fastPointer!=null && 
        fastPointer.next!=null){
        fastPointer=fastPointer.next.next;
        slowPointer=slowPointer.next;
        }
        if(fastPointer==null || fastPointer.next==null) return 0;
        slowPointer=slowPointer.next;
        int len=1;
        while(slowPointer!=fastPointer){
            slowPointer=slowPointer.next;
            len++;
        }
        return len;
    }
}
