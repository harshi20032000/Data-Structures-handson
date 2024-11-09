package com.indiavisualisedsa.ds_visualiser.models;

/**
 * point1: here the rear pointer resets to 0 after reaching capacity point2:
 * Overflow condition f==0 and r==size-1 or f==r+1
 * Underflow condition 
 */
public class CircularQueue {
	private int[] cq;
	private int f, r, size;

	public CircularQueue(int size) {
		this.size = size;
		cq = new int[size];
		f = -1;
		r = -1;
	}

	public String insert(int item) {
		if (f == 0 && r == size - 1 || f == r + 1) {
			return "Circular Queue OverFlow";
		} else {
			if (f == -1 && r == -1) {
				f = 0;
				r = 0;
			} else {
				if (r == size - 1)
					r = 1;
				else
					r = r + 1;
			}
		}
		cq[r] = item;
		return item + " is inserted";
	}

	public String delete() {
		int temp;
		if (f == -1 && r == -1) {
			return "Circular Queue UnderFlow";
		} else {
			temp = cq[f];
			cq[f] = 0;
			if (f == size - 1) {
				f = 0;
			} else if (f == r) {
				f = -1;
				r = -1;
			} else {
				f = f + 1;
			}
		}
		return temp +"is deleted";
	}
	
	public int[] getElements() {
        return cq;
    }
	
	public int getfrontPointer() {
        return f;
    }
	
	public int getrearPointer() {
        return r;
    }

}
