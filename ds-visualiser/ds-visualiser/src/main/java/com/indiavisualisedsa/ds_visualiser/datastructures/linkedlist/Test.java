package com.indiavisualisedsa.ds_visualiser.datastructures.linkedlist;

public class Test {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList(4);
		ll.append(5);
		ll.append(6);
		ll.prepend(1);
		ll.insert(1, 02);
		ll.insert(2, 3);
		ll.removeFirst();
		ll.removeLast();
		ll.append(6);
		ll.prepend(1);
		ll.getHead();
		ll.getTail();
		ll.getLength();
		ll.printList();
		ll.set(5, 8);
		ll.printList();
		ll.reverse();
		ll.printList();
	}

}
