package com.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.Insert(4);
		ll.Insert(5);
		ll.Insert(10);
		ll.Insert(7);
		ll.Insert(18);
		ll.Insert(9);
		ll.print();
		ll.delete(4);
		ll.print();
		ll.delete(9);
		ll.print();
		ll.Insert(17);
		ll.Insert(25);
		ll.delete(9);
		ll.print();
		ll.delete(7);
		ll.print();
		ll.delete(18);
		ll.print();
		ll.delete(5);
		ll.print();
		ll.delete(10);
		ll.print();
	}
}
