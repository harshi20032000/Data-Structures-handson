package com.indiavisualisedsa.ds_visualiser.scottcourse;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree(int value) {
		Node newNode = new Node(value);
		root = newNode;
	}
	
	public BinarySearchTree() {
		
	}
	
	class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value=value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
		
	}

	public static void main(String[] args) {
		BinarySearchTree myBst = new BinarySearchTree();
		System.out.println("root = " + myBst.root);
		BinarySearchTree myBst1 = new BinarySearchTree(5);
		System.out.println("root of 1= " + myBst1.root);
	}

}
