package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import com.common.Node;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BinarySearchTree {

	private Node root;
	private Set<Integer> distanceSet = new TreeSet<>();
	private Map<Integer, Node> distanceMap = new TreeMap<>();
	private Map<Integer, List<Integer>> verticalDistanceMap = new TreeMap<>();

	public void insert(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			return;
		}

		insertNode(root, node);
	}

	private void insertNode(Node root, Node node) {
		if (root.getData() >= node.getData()) {
			if (root.getLeft() == null) {
				root.setLeft(node);
				return;
			} else {
				insertNode(root.getLeft(), node);
			}
		} else {
			if (root.getRight() == null) {
				root.setRight(node);
				return;
			} else {
				insertNode(root.getRight(), node);
			}
		}
	}

	/**
	 * @author sanket
	 * @param traverseOrder
	 * 
	 *            This method calls a respective traversal method according to
	 *            string passed for traversal
	 */
	public void traverse(String traverseOrder) {
		switch (traverseOrder) {
		case "inorder":
			System.out.println("Inorder Traversal is as follow : ");
			System.out.print("[");
			traverseInorder(root);
			System.out.println("]");
			break;

		case "preorder":
			System.out.println("Preorder Traversal is as follow : ");
			System.out.print("[");
			traversePreorder(root);
			System.out.println("]");
			break;

		case "postorder":
			System.out.println("Postorder Traversal is as follow : ");
			System.out.print("[");
			traversePostorder(root);
			System.out.println("]");
			break;
		case "bfs":
			System.out.println("Breadth First Traversal or Level Order Traversal is as follow : ");
			System.out.print("[ ");
			BFSTraversal(root);
			System.out.println("]");
			break;
		case "inorder-iterative":
			System.out.println("Inorder Traversal in iterative is as follow : ");
			System.out.print("[");
			traverseInorderIterative(root);
			System.out.println("]");
			break;
		default:
			break;
		}
	}

	/**
	 * @author sanket
	 * @param node
	 * 
	 *            This method traverse a tree in an iterative inorder fashion.
	 */
	private void traverseInorderIterative(Node root) {

		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Stack<Node> stack = new Stack<>();
		// stack.push(root);
		// Node currentNode = root.getLeft();
		Node currentNode = root;
		while (!stack.isEmpty() || currentNode != null) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				Node poppedNode = stack.pop();
				System.out.print(poppedNode.getData() + " ");
				currentNode = poppedNode.getRight();
			}
		}
	}

	/**
	 * @author sanket
	 * @param root
	 * 
	 *            This method traverse a tree in inorder fashion
	 */
	private void traverseInorder(Node root) {
		// GO LEFT
		if (root.getLeft() != null) {
			traverseInorder(root.getLeft());
		}
		// PRINT SELF
		System.out.print(root.getData() + " ");
		// GO RIGHT
		if (root.getRight() != null) {
			traverseInorder(root.getRight());
		}
	}

	/**
	 * @author sanket
	 * @param root
	 * 
	 *            This method traverse a tree in preorder fashion
	 */
	private void traversePreorder(Node root) {
		// PRINT SELF
		System.out.print(root.getData() + " ");
		// GO LEFT
		if (root.getLeft() != null) {
			traversePreorder(root.getLeft());
		}
		// GO RIGHT
		if (root.getRight() != null) {
			traversePreorder(root.getRight());
		}
	}

	/**
	 * @author sanket
	 * @param root
	 * 
	 *            This method traverse a tree in postorder fashion
	 */
	private void traversePostorder(Node root) {
		// GO LEFT
		if (root.getLeft() != null) {
			traversePostorder(root.getLeft());
		}
		// GO RIGHT
		if (root.getRight() != null) {
			traversePostorder(root.getRight());
		}
		// PRINT SELF
		System.out.print(root.getData() + " ");
	}

	/**
	 * @author sanket
	 * @param root
	 * 
	 *            This method traverse a tree in Breadth first or level order
	 */
	private void BFSTraversal(Node root) {
		List<Node> list = new ArrayList<>();
		list.add(root);
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			System.out.print(node.getData() + " ");
			if (node.getLeft() != null)
				list.add(node.getLeft());
			if (node.getRight() != null)
				list.add(node.getRight());
		}
	}

	/**
	 * @author sanket
	 * 
	 *         This method prints top or bottom view of the tree
	 */
	public void printTreeView(String view) {
		switch (view) {
		case "top":
			System.out.println("Top view of the tree");
			printTreeTopView(this.root, 0);
			System.out.println("");
			break;

		case "bottom":
			System.out.println("Bottom view of the tree");
			printTreeBottomView(this.root, 0);
			break;

		default:
			break;
		}
	}

	/**
	 * @author sanket
	 * @param root
	 * 
	 *            This method traverse a tree in preorder fashion and prints a top
	 *            view of the tree
	 */
	private void printTreeTopView(Node root, Integer distance) {
		// PRINT SELF
		if (!distanceSet.contains(distance)) {
			System.out.print(root.getData() + " ");
			distanceSet.add(distance);
		}
		// GO LEFT
		if (root.getLeft() != null) {
			printTreeTopView(root.getLeft(), distance - 1);
		}
		// GO RIGHT
		if (root.getRight() != null) {
			printTreeTopView(root.getRight(), distance + 1);
		}
	}

	/**
	 * @author sanket
	 * @param node
	 * 
	 *            This method traverse a tree in preorder fashion and prints a top
	 *            view of the tree
	 */
	private void printTreeBottomView(Node node, Integer distance) {
		traverseTreeForBottomView(node, distance);
		Iterator<Entry<Integer, Node>> iterator = distanceMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Node> entry = iterator.next();
			Node value = entry.getValue();
			System.out.print(value.getData() + " ");
		}
	}

	/**
	 * @author sanket
	 * @param node
	 * 
	 *            This method traverse a tree in preorder fashion and prints a top
	 *            view of the tree
	 */
	private void traverseTreeForBottomView(Node node, Integer distance) {
		// PRINT SELF
		// if (!distanceSet.contains(distance)) {
		distanceMap.put(distance, node);
		// }
		// GO LEFT
		if (node.getLeft() != null) {
			traverseTreeForBottomView(node.getLeft(), distance - 1);
		}
		// GO RIGHT
		if (node.getRight() != null) {
			traverseTreeForBottomView(node.getRight(), distance + 1);
		}
	}

	/**
	 * @author sanket
	 * 
	 *         This method prints node in vertical order
	 */
	public void printVerticalNodes() {
		System.out.println("Printing vertical nodes");
		traverseVertical(this.root, 0);
		Iterator<Entry<Integer, List<Integer>>> iterator = this.verticalDistanceMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, List<Integer>> pair = iterator.next();
			List<Integer> list = pair.getValue();
			System.out.print("Distance " + pair.getKey() + ":");
			for (Integer data : list) {
				System.out.print(data + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * @author sanket
	 * @param root
	 * @param distance
	 * 
	 *            This method traverse a tree in preorder fashion and add each node
	 *            value to list in a map according to its vertical distance from
	 *            root node.
	 */
	private void traverseVertical(Node root, Integer distance) {
		// PRINT SELF
		List<Integer> list = this.verticalDistanceMap.get(distance);
		if (list == null)
			list = new LinkedList<Integer>();
		list.add(root.getData());
		this.verticalDistanceMap.put(distance, list);

		// GO LEFT
		if (root.getLeft() != null) {
			traverseVertical(root.getLeft(), distance - 1);
		}
		// GO RIGHT
		if (root.getRight() != null) {
			traverseVertical(root.getRight(), distance + 1);
		}
	}

	public void findLowestCommonAncestor(int node1, int node2) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Integer lca = traverseForLowestCommonAncestor(root, node1, node2);
		if (lca == null) {
			System.out.println("No common ancestor found");
		}
	}

	private Integer traverseForLowestCommonAncestor(Node node, int node1, int node2) {
		if (node == null) {
			return null;
		}
		if (node1 < node.getData() && node.getData() < node2) {
			System.out.println("Common lowest ancestor : " + node.getData());
			return node.getData();
		} else if (node.getData() < node1 && node.getData() < node2) {
			return traverseForLowestCommonAncestor(node.getRight(), node1, node2);
		} else {
			return traverseForLowestCommonAncestor(node.getLeft(), node1, node2);
		}
	}
}
