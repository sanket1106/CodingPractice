package com.common;

import lombok.Data;

@Data
public class Node {

	private int data;
	private Node left;
	private Node right;
	private Node next;

	public Node(int data) {
		this.data = data;
	}
}
