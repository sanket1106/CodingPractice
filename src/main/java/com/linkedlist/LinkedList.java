package com.linkedlist;

import com.common.Node;

import lombok.Data;

@Data
public class LinkedList {
	private Node head = null;

	Node Insert(int data) {
		System.out.println("Inserting " + data);
		Node node = new Node(data);
		if (this.head == null) {
			this.head = node;
			return this.head;
		} else {
			Node next = this.head;
			while (next.getNext() != null) {
				next = next.getNext();
			}
			next.setNext(node);
			return this.head;
		}
	}

	public void print() {
		if (this.head == null) {
			return;
		} else {
			System.out.println("Printing Linkedlist...");
			Node next = this.head;
			while (next != null) {
				System.out.print(next.getData() + " ");
				next = next.getNext();
			}
			System.out.println("");
		}
	}

	public void delete(int data) {
		if (this.head == null) {
			System.out.println("Linked list is null. Nothing to delete");
		} else if (this.head.getData() == data) {
			System.out.println("Deleteing " + data);
			this.head = this.head.getNext();
		} else {
			Node node = this.head;
			while (node.getNext() != null && node.getNext().getData() != data) {
				node = node.getNext();
			}
			if (node.getNext() == null) {
				System.out.println(data + " not found");
			} else {
				node.setNext(node.getNext().getNext());
				System.out.println("Deleting " + data);
			}
		}
	}
}
