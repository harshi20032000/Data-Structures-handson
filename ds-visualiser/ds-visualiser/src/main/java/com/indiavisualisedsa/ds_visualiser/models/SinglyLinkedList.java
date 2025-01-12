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
	
	

	public String insertBeg(int x) {
		Node newNode = new Node(x);
		newNode.link = this.head;
		head=newNode;
		return x +" is added.";
	}

	public String insertMid(int x, int p) {
		if(p==0) {
			insertBeg(x);
			return x +" is added.";
		}
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

	public String insertEnd(int x) {
		Node newNode = new Node(x);
		Node ptr = this.head;
		while (ptr.link != null) {
			ptr = ptr.link;
		}
		ptr.link = newNode;
		return x+" is added.";
	}

	public String delete(int p) {
		if(p==0) {
			Node temp=head;
			head = head.link;
			temp.link=null;
			return "Node at position "+p+" is deleted.";
		}
		Node ptr = this.head;
		int count = 1;
		while (count < p) {
			ptr = ptr.link;
			count++;
		}
		Node ptr1 = ptr.link;
		ptr.link = ptr.link.link;
		ptr1.link = null;
		return "Node at position "+p+" is deleted.";
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
