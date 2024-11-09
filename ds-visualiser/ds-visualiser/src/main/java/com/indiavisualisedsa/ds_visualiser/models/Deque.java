package com.indiavisualisedsa.ds_visualiser.models;

public class Deque {

	private int[] dq;
	private int f, r, size;
	
	Deque(int n){
		size = n;
		dq = new int[size];
		f=-1;
		r=-1;
	}
	
	String insertFront(int item) {
		if(f==0)
			return "Deque Over Flows";
		else if(f==-1 && r==-1) {
			f=0; r=0;
		}
		else
			f=f-1;
		dq[f]=item;
		return item +"is inserted";
	}
	
	String insertRear(int item) {
		if(r==size)
			return "Deque Over Flows";
		else if(f==-1 && r==-1) {
			f=0; r=0;
		}
		else
			r=r+1;
		dq[r]=item;
		return item+"is inserted";
	}
	
	String deleteFront() {
		if(f==-1 && r==-1)
			return "Deque Under Flows";
		int temp=dq[f];
		
		if(f==r)
		{
			f=-1;
			r=-1;
		}
		else
			f=f+1;
		return temp +"is removed";
	}
	
	String deleteRear() {
		if(f==-1 && r==-1)
			return "Deque Under Flows";
		int temp=dq[r];
		
		if(f==r)
		{
			f=-1;
			r=-1;
		}
		else
			r=r-1;
		return temp +"is removed";
	}
	
	public int[] getElements() {
		return dq;
	}

	public int getfrontPointer() {
		return f;
	}

	public int getrearPointer() {
		return r;
	}
	
}
