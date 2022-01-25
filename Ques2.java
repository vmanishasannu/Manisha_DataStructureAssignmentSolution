package com.greatLearning.trees;

class Node {
	int data;
	Node left;
	Node right;
	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class Ques2{
	public static Node node;
	static Node previousNode = null;
	static Node head = null;
	void covertBstToSkew(Node root) { // covert BST to skew
		if (root == null) {return;}

		covertBstToSkew(root.left);
		Node rightNode = root.right;
		if (head == null) {
			head = root;
			root.left = null;
			previousNode = root;
		} else {
			previousNode.right = root;
			root.left = null;
			previousNode = root;
		}
		covertBstToSkew(rightNode);
	}

	// traverse right skewed tree
	 void printTree(Node root) {
		if (root == null) {return;}
		System.out.print(root.data + " ");
		printTree(root.right);
	}

	public static void main(String[] args) {
		Ques2 tree = new Ques2();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(40);
		tree.covertBstToSkew(node);
		tree.printTree(head);
	}
}