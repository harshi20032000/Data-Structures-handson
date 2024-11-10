package com.indiavisualisedsa.ds_visualiser.models;

public class SinglyLinkedList {

	int data;
	SinglyLinkedList link;
	
	SinglyLinkedList(int item){
		data=item;
		link=null;
	}
	
	void insertBeg(SinglyLinkedList start, int value) {
		SinglyLinkedList newNode = new SinglyLinkedList(value);
		newNode.link=start;
		
	}
	
	void insertMid(SinglyLinkedList start, int value, int index) {
		SinglyLinkedList newNode = new SinglyLinkedList(value);
		SinglyLinkedList ptr = start;
		int count=1;
		while(count<index) {
			ptr=ptr.link;
			count++;
		}
		newNode.link=ptr.link;
		ptr.link=newNode;
	}
	
	void insertEnd(SinglyLinkedList start, int value) {
		SinglyLinkedList newNode = new SinglyLinkedList(value);
		SinglyLinkedList ptr = start;
		while(ptr.link!=null) {
			ptr=ptr.link;
		}
		ptr.link=newNode;
	}
	
	void delete(SinglyLinkedList start, int index) {
		SinglyLinkedList ptr = start;
		int count=1;
		while(count<index) {
			ptr=ptr.link;
			count++;
		}
		SinglyLinkedList ptr1 = ptr.link;
		ptr.link=ptr.link.link;
		ptr1.link=null;
	}
	
}
