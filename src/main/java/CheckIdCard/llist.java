package CheckIdCard;

public class llist {

    public static void main(String[] arg) {
        Node head = new Node(1);
        for(int i = 2; i < 10; i++){
            insertFromTail(head, new Node(i));
        }
        printList(head);
        deleteFromIndex(head,3);
        printList(head);
        System.out.println(isLoop(head));

    }

    public static Boolean isLoop(Node head) {
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

    //从头节点插入，比较简单不用遍历链表
    public static void insetFromHead(Node head,Node newNode){
        newNode.next=head;
        head = newNode;
    }

    //在尾部插入，要遍历链表
    public static void insertFromTail(Node head1, Node newNode){
        if(head1 == null){ //如果是个空链表，直接把新节点赋值给head，然后结束，要先判断null的情况    其实这是一段错误代码，大家可以查看我另外一篇文章，Java参数引用传递之例外：null
            head1 =newNode;
            return;
        }
        Node temp = head1; //用temp代替head去遍历找到最后一个节点，一定不要用head自己去遍历，不然就找不到链表头了
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    //计算链表的长度
    public  static int length(Node head){
        int len =0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }

    //从特定位置删除一个节点
    public static boolean deleteFromIndex(Node head,int index){
        if(index<1||index>length(head)){ //先判断是否越界
            return false;
        }
        if(index ==1){//如果是删除第一个元素，因为直接涉及到了head所以只能单独处理
            head = head.next;
            return true;
        }
        Node curNode = head;
        for(int curIndex =1;curIndex<index-1;curIndex++){ //删除顺序为index的node只能将curNode停在index-1的位置
            curNode = curNode.next;
        }
        curNode.next=curNode.next.next;
        return true;
    }

    //按照顺序输出一个列表
    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    //对链表进行冒泡排序
    public static void orderList(Node head){

    }

}
