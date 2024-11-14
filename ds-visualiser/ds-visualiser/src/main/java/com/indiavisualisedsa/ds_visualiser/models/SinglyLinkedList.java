package com.indiavisualisedsa.ds_visualiser.models;

public class SinglyLinkedList {

	int data;
	SinglyLinkedList link;

	SinglyLinkedList(int item) {
		data = item;
		link = null;
	}

	String insertBeg(SinglyLinkedList start, int value) {
		SinglyLinkedList newNode = new SinglyLinkedList(value);
		newNode.link = start;
		return value +" is added.";
	}

	String insertMid(SinglyLinkedList start, int value, int index) {
		SinglyLinkedList newNode = new SinglyLinkedList(value);
		SinglyLinkedList ptr = start;
		int count = 1;
		while (count < index) {
			ptr = ptr.link;
			count++;
		}
		newNode.link = ptr.link;
		ptr.link = newNode;
		return value +" is added.";
	}

	String insertEnd(SinglyLinkedList start, int value) {
		SinglyLinkedList newNode = new SinglyLinkedList(value);
		SinglyLinkedList ptr = start;
		while (ptr.link != null) {
			ptr = ptr.link;
		}
		ptr.link = newNode;
		return value+" is added.";
	}

	String delete(SinglyLinkedList start, int index) {
		SinglyLinkedList ptr = start;
		int count = 1;
		while (count < index) {
			ptr = ptr.link;
			count++;
		}
		SinglyLinkedList ptr1 = ptr.link;
		ptr.link = ptr.link.link;
		int temp = ptr1.data;
		ptr1.link = null;
		return "Node with Value "+temp+" is deleted.";
	}

	// Utility method to generate a string representation of the linked list
	// elements
	String getElementsAsString(SinglyLinkedList list) {
		StringBuilder sb = new StringBuilder();
		SinglyLinkedList current = list.link; // Start from the first actual node after the dummy head

		while (current != null) {
			sb.append(current.data).append(" -> ");
			current = current.link;
		}
		sb.append("null"); // End of list marker
		return sb.toString();
	}

}
