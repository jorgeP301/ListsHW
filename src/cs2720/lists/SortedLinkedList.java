package cs2720.lists;
//great

public class SortedLinkedList {

    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        head = null;
        currentPos = head;
    } //initialize a SLL object

    public int getLength() {
        if (isEmpty()) {
            return 0;
        }
        else {
            NodeType temp = head;
            int length = 0;
            while (currentPos != null) {
                temp = temp.next;
                length++;
            }
            return length;
        }
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        else  {
            return false;
        }
    }

    public void insertItem(ItemType item) {
        if (head == null) {
            head.info = item;
        }
        else {
            NodeType node = new NodeType();
            node.info = item;
            NodeType node1 = new NodeType();
            NodeType node2 = new NodeType();
            node1 = head;
            node2 = null;
            while(node1 != null) {
                if(item.compareTo(node.info) == -1) {
                    node2 = node1;
                    node1 = node1.next;
                }
                else if (item.compareTo(node.info) == 0){
                    System.out.println("Sorry. You cannot insert the duplicate item.");
                    break;
                }
                else {
                    node2.next = node;
                    node.next = node1;
                    break;
                }
            }
        }
    }

    public void deletItem(ItemType item) {
        //general case
        NodeType node1 = head;
        NodeType node2 = null;
        while (node1 != null) {
            if( item.compareTo(node1.info) != 0) {
                node2 = node1;
                node1 = node1.next;
            } else {
                break;
            }
        }
        node1.info = null;
        node2.next = node1.next;
    }

    //public int searchItem(ItemType item) {

    //}

    // public ItemType getNextItem() {

    //}

    public void resetList() {

    }
}

    //mergeList

    // delete alternate nodes

    //intersection
