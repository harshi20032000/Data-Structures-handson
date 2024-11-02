package com.indiavisualisedsa.ds_visualiser.models;

public class Queue {

	private int[] q;
	private int f, r;
	private int n;

	public Queue(int size) {
		this.n = size;
		q = new int[size];
		f = -1;
		r = -1;
	}

	public String insert(int item) {
		if (r == n - 1) {
			return "Queue OverFlow";
		} else {
			if (f == -1 && r == -1) {
				f = 0;
				r = 0;
			} else {
				r = r + 1;
			}

		}
		q[r] = item;
		return "Item inserted: " + item;
	}
	
	public String delete() {
		int temp;
		if(f==-1 && r==-1) {
			return "Queue UnderFlow";
		}else {
			temp=q[f];
			q[f]=0;
			if(f==r) {
				f=-1;
				r=-1;
			}
			else {
				f=f+1;
			}
		}
		return "Item deleted: "+temp;
	}
	
	public int[] getElements() {
        return q;
    }
	
	public int getfrontPointer() {
        return f;
    }
	
	public int getrearPointer() {
        return r;
    }

}
