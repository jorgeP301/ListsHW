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
        if (isEmpty()) {
            NodeType node = new NodeType();
            node.info = item;
            this.head = node;
            this.currentPos = head;
            head.next = null;
        } //insert into empty list case

        else { //inserting into populated list
            NodeType node = new NodeType();
            node.info = item; //create new node and give it its value
            NodeType node1;
            NodeType node2;
            node1 = head;
            node2 = null;
            if(searchItem(item) != 0) { //inseritng duplicate
                System.out.println("sorry you cannot add duplicates");
            }
            else {
                while(node1 != null && item.compareTo(node1.info) == 1) {
                    node2 = node1;
                    node1 = node1.next;
                }
                if(node2 ==null) { // insert at beginning
                    node.next = node1;
                    head = node;
                }
                else {
                    node2.next = node;
                    node.next = node1;
                }
            }
        }
    }

    public void deleteItem(ItemType item) {
        if(isEmpty()) {
            System.out.print("the list is empty");
        }
        else if(printLength() == 1) {
            head = null;
        }
        else if(searchItem(item) == 0) {
            System.out.println("the item is not in the list");
        }
        else {
//general case
            NodeType node1 = head;
            NodeType node2 = null;
            while (node1 != null) {
                if( item.compareTo(node1.info) == 0) {
                    break;
                } else {
                    node2 = node1;
                    node1 = node1.next;
                }
            }
            node1.info = null;
            node2.next = node1.next;
        }
    }

    public int searchItem(ItemType item) {
        NodeType temp = head;
        int index = 1;
        while( temp != null) {
            if(item.compareTo(temp.info) == 0) {
                return index;
            }
            else {
                temp = temp.next;
                index++;
            }
        }
        index = 0;//means the item is not in the list
        return index;
    }

    public ItemType getNextItem() {
        if(isEmpty()) {
            throw new IllegalStateException("The list is empty");
        }
        else {
            NodeType temp;
            if(currentPos != null) {
                temp = currentPos;
                temp.info = currentPos.info;
                currentPos = currentPos.next;
                return temp.info;
            }
            else {
                resetList();
                currentPos = head;
                temp = currentPos;
                temp.info = currentPos.info;
                currentPos = currentPos.next;
                return temp.info;
            }
        }

    }

    public void resetList() {
        currentPos = null;
    }


    public void mergeList(SortedLinkedList l) {
        l.currentPos = l.head;
        while(l.currentPos != null) {
            insertItem(l.currentPos.info);
            l.currentPos = l.currentPos.next;
        }
    }


    public void deleteAlternateNodes() {
        currentPos = head;
        int index = 1;
        while (currentPos != null) {
            if (index % 2 == 0) {
                NodeType temp = new NodeType();
                temp = currentPos;
                deleteItem(currentPos.info);
                index++;
                currentPos = temp.next;
            }
            else {
                currentPos = currentPos.next;
                index++;
            }
        }

    }
    public SortedLinkedList intersection(SortedLinkedList l) {
        SortedLinkedList result = new SortedLinkedList();
        while(currentPos != null) {
            while (l.currentPos != null) {
                if(l.currentPos.info.compareTo(this.currentPos.info) == 0 ) {
                    result.insertItem(this.currentPos.info);
                    l.currentPos = l.currentPos.next;
                }
                else {
                    l.currentPos = l.currentPos.next;
                }

                currentPos = currentPos.next;
            }
        }
        return result;
        //O(n^2)
    }
    public void printList() {
        currentPos = head;
        if(isEmpty()) {
            System.out.print("Empty");
        }
        else {
            while(currentPos != null) {
                System.out.print(currentPos.info.getValue() + " ");
                currentPos = currentPos.next;
            }
        }
    }
    public int  printLength() {
        currentPos = head;
        int length = 0;
        while(currentPos != null) {
            length++;
            currentPos = currentPos.next;
        }
        return length;
    }
}
