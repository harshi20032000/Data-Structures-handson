package com.indiavisualisedsa.ds_visualiser.models;

public class SinglyLinkedList {
	
	class Node{
		int data;
		Node link;

		Node(int item) {
			data = item;
			link = null;
		}
		
		Node(){
			data=0;
			link=null;
		}
	}
	
	Node head;

	
	
	public SinglyLinkedList(int x) {
		head = new Node(x);
	}
	
	

	String insertBeg(int x) {
		Node newNode = new Node(x);
		newNode.link = this.head;
		return x +" is added.";
	}

	String insertMid(int x, int p) {
		Node newNode = new Node(x);
		Node ptr = this.head;
		int count = 1;
		while (count < p) {
			ptr = ptr.link;
			count++;
		}
		newNode.link = ptr.link;
		ptr.link = newNode;
		return x +" is added.";
	}

	String insertEnd(int x) {
		Node newNode = new Node(x);
		Node ptr = this.head;
		while (ptr.link != null) {
			ptr = ptr.link;
		}
		ptr.link = newNode;
		return x+" is added.";
	}

	String delete(int p) {
		Node ptr = this.head;
		int count = 1;
		while (count < p) {
			ptr = ptr.link;
			count++;
		}
		Node ptr1 = ptr.link;
		ptr.link = ptr.link.link;
		int temp = ptr1.data;
		ptr1.link = null;
		return "Node with Value "+temp+" is deleted.";
	}

	// Utility method to generate a string representation of the linked list
	// elements
	public String getElementsAsString() {
		StringBuilder sb = new StringBuilder();
		Node current = this.head; // Start from the first actual node after the dummy head

		while (current != null) {
			sb.append(current.data).append(" -> ");
			current = current.link;
		}
		sb.append("null"); // End of list marker
		return sb.toString();
	}

}
