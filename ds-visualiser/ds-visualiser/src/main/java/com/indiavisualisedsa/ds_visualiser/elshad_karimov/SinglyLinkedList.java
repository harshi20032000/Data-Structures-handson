package com.indiavisualisedsa.ds_visualiser.elshad_karimov;

public class SinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public Node insertSinglyLinkedList(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	// Insert Method SinglyLinkedList
	public void push(int nodeValue) {
		if (head == null) {
			insertSinglyLinkedList(nodeValue);
		} else {
			Node node = new Node();
			node.value = nodeValue;
			node.next = null;
			tail.next = node;
			tail = node;
			size++;
		}

	}

	public Node pop() {

		if (head == null) {
			System.out.println("The SLL does not exist");
			return null;
		}
		Node removeNode;
		Node currentNode;
		if (head == tail) {
			removeNode = head;
			head = tail = null;
		} else {
			currentNode = head;
			while (currentNode.next != tail) {
				currentNode = currentNode.next;
			}
			removeNode = currentNode.next;
			currentNode.next = null;
			tail = currentNode;
		}
		size--;

		return removeNode;
	}

	public Node get(int index) {
		if (index < 0 || index > size - 1)
			return null;
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public String rotate(int number) {
	    int index = number;
	    if (number < 0) {
	      index = number + size;
	    }
	    if (index < 0 || index >= size) {
	      return null;
	    }
	    if (index == 0) {
	      return "No Rotation";
	    }
	    Node prevNode = head;
	    for(int i=0; i<index-1; i++) {
	      prevNode = prevNode.next;  
	    }
	    if (prevNode == null) {
	        return "No Rotation";
	      }
	    tail.next = head;
	    head = prevNode.next;
	    tail = prevNode;
	    prevNode.next = null;
	    return "Success";}
	
	public Node remove(int index) {
	    if (index<0 || index >= size) {
	      return null;
	    }
	    Node removeNode;
	    Node currentNode;
	    size--;
	    if (index == 0) {
	      removeNode = head;
	      if (head == tail) {
	        head = tail = null;
	      } else {
	        head = head.next;
	      }
	      return removeNode;    
	    } else {
	      currentNode = head;
	      int indx = 0;
	      while (indx < index - 1) {
	        currentNode = currentNode.next;
	        indx ++;
	      }
	      removeNode = currentNode.next;
	      Node nextNode = currentNode.next;
	      currentNode.next = nextNode.next;
	      return removeNode;
	    }
	  }

}
