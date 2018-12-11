package CheckIdCard;

import java.util.LinkedList;

public class linkedList {

    public class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public Boolean isLoop(LinkedList list) {

        Node slow, fast;
        boolean isloop = false;
        slow = fast = list.getFirst();
    }

}
