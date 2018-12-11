package CheckIdCard;

public class ListNode
{
    int val;
    ListNode next;

    public ListNode(int x){
        val=x;
    }

    public void main(ListNode head) {
        ListNode slowPointer, fastPointer;

        slowPointer = fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                System.out.println("true");
            }
        }
        System.out.println("false");
    }

}
