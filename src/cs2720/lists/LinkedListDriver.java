package cs2720.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

    public static void main(String[] args) {
        Scanner sc;
        SortedLinkedList original = new SortedLinkedList();
        try {
            sc = new Scanner(new File(args[0]));
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                ItemType temp = new ItemType(num);
                original.insertItem(temp);
            }
        }
        catch(FileNotFoundException fnf) {
            System.out.println("file not found");
            System.exit(0);
        }

        sc = new Scanner(System.in);

        System.out.println("Commands:");
        System.out.println("(i) - Insert Value");
        System.out.println("(d) - Delete Value");
        System.out.println("(s) - Search Value");
        System.out.println("(n) - Print Next Iterator Value");
        System.out.println("(r) - Reset Iterator");
        System.out.println("(a) - Delete Alternate Nodes");
        System.out.println("(m) - Merge Lists");
        System.out.println("(t) - Find Intersection");
        System.out.println("(p) - Print List");
        System.out.println("(l) - Print Length");
        System.out.println("(q) - Quit Program");

        String comm = "";
        Boolean running = true;
        while(running) {
            System.out.println("Enter a command");
            comm = sc.nextLine();
            int tempNum;
            ItemType item;
            switch (comm) {
            case "i":
                System.out.print("Enter a number to insert: ");
                tempNum = sc.nextInt();
                item = new ItemType(tempNum);
                sc.nextLine();
                System.out.print("Original list: ");
                original.printList();
                sc.nextLine();
                original.insertItem(item);
                System.out.print("New list: ");
                original.printList();
                sc.nextLine();
                break;
            case "d":
                System.out.print("Enter a number to delete: ");
                tempNum = sc.nextInt();
                item = new ItemType(tempNum);
                sc.nextLine();
                System.out.print("Original list: ");
                original.printList();
                sc.nextLine();
                original.deleteItem(item);
                System.out.print("new list: ");
                original.printList();
                sc.nextLine();
                break;
            case "s":
                System.out.print("Enter a number to search: ");
                tempNum = sc.nextInt();
                item = new ItemType(tempNum);
                int steve = original.searchItem(item);
                sc.nextLine();
                System.out.print("original list: ");
                original.printList();
                sc.nextLine();
                if(original.isEmpty() ) {
                    System.out.print("list is empty");
                    sc.nextLine();
                    break;
                }
                else if (steve == 0) {
                    System.out.print("item is not in the list");
                    sc.nextLine();
                    break;
                }
                else {
                    System.out.print("the item is at index " + steve);
                    sc.nextLine();
                    break;
                }
            case "n":
                tempNum = 0;
                System.out.println(original.getNextItem().getValue());
                break;
            case "r":
                original.resetList();
                System.out.println("the iterator is reset");
                break;
            case "a":
                System.out.print("Original list: ");
                original.printList();
                sc.nextLine();
                original.deleteAlternateNodes();
                System.out.println("new list: ");
                original.printList();
                sc.nextLine();
                break;
            case "m":
                System.out.print("enter the length of the new list: ");
                tempNum = sc.nextInt();
                sc.nextLine();
                SortedLinkedList tempList = new SortedLinkedList();
                System.out.print("enter your numbers");
                for(int i = 0; i < tempNum; i++) {
                    item = new ItemType(sc.nextInt());
                    tempList.insertItem(item);
                }
                sc.nextLine();
                System.out.print("list 1: ");
                original.printList();
                sc.nextLine();
                System.out.print("list 2: ");
                tempList.printList();
                sc.nextLine();
                original.mergeList(tempList);
                System.out.print("merged list: ");
                original.printList();
                sc.nextLine();
                break;
            case "t":
                System.out.print("enter the length of the new list: ");
                tempNum = sc.nextInt();
                sc.nextLine();
                tempList = new SortedLinkedList();
                System.out.print("enter your numbers");
                for(int i = 0; i < tempNum; i++) {
                    item = new ItemType(sc.nextInt());
                    tempList.insertItem(item);
                }
                sc.nextLine();
                System.out.print("list 1:");
                original.printList();
                sc.nextLine();
                System.out.print("list 2:");
                tempList.printList();
                sc.nextLine();
                original.intersection(tempList);
                System.out.print("Intersection of lists: ");
                original.printList();
                break;
            case "p":
                System.out.print("the list is: ");
                original.printList();
                break;
            case "l":
                System.out.print("the length of the list is: " + original.printLength());
                break;
            case "q":
                System.out.print("Exiting the program...");
                System.exit(0);
                break;
            default :
                System.out.print("invalid command");
            }
        }
    }//main
}
