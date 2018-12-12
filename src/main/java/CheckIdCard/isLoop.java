package CheckIdCard;

public class isLoop {

    public Boolean looplinkedlist(Node head) {
        Node slowPointer, fastPointer;
        slowPointer = fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                return true;
            }
        }
        return false;

    }

    static class Node {
        int data;
        Node next;

        public  Node(int d) {
            data = d;
            next = null;
        }
    }

}
