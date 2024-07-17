package datastructures.linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedList myLinkedList = new LinkedList(1);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();
        
        System.out.println("\nremove Last");
        
        myLinkedList.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList.removeLast().value);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList.removeLast().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList.removeLast());
        
        
    	/*
        	EXPECTED OUTPUT:
        	----------------
        	2
        	1
        	null

     	*/
        myLinkedList.makeEmpty();
        myLinkedList = new LinkedList(2);
        myLinkedList.append(3);

        System.out.println("Before prepend():");
        System.out.println("-----------------");
        myLinkedList.printList();

        myLinkedList.prepend(1);

        System.out.println("\n\nAfter prepend():");
        System.out.println("----------------");
        myLinkedList.printList();

        
        /*
            EXPECTED OUTPUT:
    
            Before prepend():
            -----------------
            Head: 2
            Tail: 3
            Length: 2
    
            Linked List:
            2
            3
    
    
            After prepend():
            ----------------
            Head: 1
            Tail: 3
            Length: 3
    
            Linked List:
            1
            2
            3

        */
        System.out.println("removeFirst():");
        myLinkedList.makeEmpty();
        myLinkedList = new LinkedList(2);
        myLinkedList.append(1);
       
        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList.removeFirst().value);
        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList.removeFirst().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList.removeFirst());


        /*
            EXPECTED OUTPUT:
            ----------------
            2
            1
            null

        */
        System.out.println("get():");
        myLinkedList.makeEmpty();
        myLinkedList = new LinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);


        System.out.println(myLinkedList.get(3).value);


        /*
            EXPECTED OUTPUT:
            ----------------
            3

        */
        System.out.println("set():");
        myLinkedList.makeEmpty();
        myLinkedList = new LinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);

        System.out.println("Linked List before set():");
        myLinkedList.printList();

        myLinkedList.set(2, 99);

        System.out.println("\nLinked List after set():");
        myLinkedList.printList();

        
        /*
            EXPECTED OUTPUT:
            ----------------
            Linked List before set():
            0
            1
            2
            3
            
            Linked List after set():
            0
            1
            99
            3

        */


	}

}
