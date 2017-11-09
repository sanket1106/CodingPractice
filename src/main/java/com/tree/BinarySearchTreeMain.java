package com.tree;

import java.util.Scanner;

public class BinarySearchTreeMain {

	public static void main(String[] args) {
		BinarySearchTree bst = constructBinarySearchTree();
		// bst.traverse("preorder");
		bst.traverse("inorder");
		// bst.traverse("postorder");
		// bst.traverse("bfs");
		// bst.printTreeView("top");
		// bst.printTreeView("bottom");
		// bst.printVerticalNodes();
		bst.traverse("inorder-iterative");
		// lowestCommonAncestor(bst);
	}

	private static void lowestCommonAncestor(BinarySearchTree bst) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter node 1 value");
		int node1 = sc.nextInt();
		System.out.println("Enter node 2 value");
		int node2 = sc.nextInt();
		bst.findLowestCommonAncestor(node1, node2);
	}

	/**
	 * @author sanket
	 * @return
	 * 
	 * 		This method will create a binary search tree as per user's input of
	 *         no of nodes and respective node values
	 * 
	 */
	private static BinarySearchTree constructUserDefinedBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Enter no of nodes");
		Scanner sc = new Scanner(System.in);
		int noOfNodes = sc.nextInt();
		for (int i = 0; i < noOfNodes; i++) {
			System.out.println("Enter value for node " + (i + 1));
			int value = sc.nextInt();
			bst.insert(value);
		}
		// sc.close();
		System.out.println("Constructed Tree");
		System.out.println(bst);
		return bst;
	}

	/**
	 * @author sanket
	 * @return
	 * 
	 * 		This method will create a binary search tree as per pre defined node
	 *         values in a array
	 * 
	 */
	private static BinarySearchTree constructBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree();
		int[] nodes = { 6, 4, 3, 7, 14, 5, 10, 12, 1 };
		int noOfNodes = nodes.length;
		for (int i = 0; i < noOfNodes; i++) {
			bst.insert(nodes[i]);
		}
		return bst;
	}

}
