package com.indiavisualisedsa.ds_visualiser.elshad_karimov;

public class CircularSinglyLinkedList {
	Node head;
	Node tail;
	int length;

	public CircularSinglyLinkedList() {
		head = tail = null;
		length = 0;
	}
	
	public void append(int value) {
		Node newNode = new Node();
		newNode.value=value;
		if(length==0)
			head=tail=newNode;
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		length++;
    }
	
	public void prepend(int value) {
		Node newNode = new Node();
		newNode.value=value;
		if(length==0)
			head=tail=newNode;
		else
		{
			newNode.next=head;
			head=newNode;
			
		}
			length++;
	    
		
    }
	
	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node ptr = head;
        while(ptr!=null) {
        	sb.append(ptr.value+"-> ");
        	ptr=ptr.next;
        }
        sb.append("null");
        return sb.toString();
    }
	
	public boolean deleteByValue(int value) {
		if(head!=null)
			return false;
		Node pre=head;
        Node ptr =head;
        
        while(ptr!=null) {
        	if(ptr.value==value)
        		break;
        	pre=ptr;
        	ptr=ptr.next;
        }
        
        if(ptr!=null && pre!=null) {
        	pre.next=ptr.next;
        	ptr.next=null;
        	return true;
        }
        if(ptr==pre) {
        	pre.next=ptr.next;
        	ptr.next=null;
        	return true;
        }
        return false;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
