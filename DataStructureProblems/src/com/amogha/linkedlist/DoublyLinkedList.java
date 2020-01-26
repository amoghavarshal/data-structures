package com.amogha.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;

	private class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;

		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	public void addFirst(T elem) {
		if (isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			Node<T> temp = new Node<T>(elem, null, head);
			head.prev = temp;
			head = temp;
		}
		size++;
	}

	public void addLast(T elem) {
		if (isEmpty()) {
			head = tail = new Node<T>(elem, null, null);
		} else {
			Node<T> temp = new Node<T>(elem, tail, null);
			tail.next = temp;
			tail = temp;
		}
		size++;
	}

	public Node<T> find(Object elem) {
		Node<T> found = null;
		Node<T> trav = head;
		if (elem == null) {
			while (trav != null) {
				if (trav.data == null) {
					found = trav;
					break;
				}
				trav = trav.next;
			}
		} else {
			while (trav != null) {
				if (elem.equals(trav.data)) {
					found = trav;
					break;
				}
				trav = trav.next;
			}
		}
		return found;
	}

	public T findAtIndex(int index) throws IllegalStateException,
			IndexOutOfBoundsException {
		return getNodeByIndex(index).data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		Node<T> trav = head;
		while (trav != null) {
			if (sb.length() == 0) {
				sb.append("[").append(trav.data);
			} else {
				sb.append(", ");
				sb.append(trav.data);
			}
			trav = trav.next;
		}
		sb.append("]");
		return sb.toString();
	}

	public void deleteByValue(T elem) throws Exception {
		Node<T> found = find(elem);
		deleteNode(found);
	}

	private void deleteNode(Node<T> node) throws Exception {
		if (node == null)
			throw new Exception("Element not found");

		if (node.prev == null) {
			removeHead();
		} else if (node.next == null) {
			removeTail();
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
			node = null;
			size--;
		}
	}

	private Node<T> getNodeByIndex(int index) {
		if (isEmpty())
			throw new IllegalStateException("Stack is empty");

		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException();

		Node<T> found = null;
		Node<T> trav = head;
		int i = 0;
		while (trav != null) {
			if (i == index) {
				found = trav;
				break;
			}
			trav = trav.next;
			i++;
		}
		return found;
	}

	public void deleteByIndex(int index) throws Exception {
		Node<T> node = getNodeByIndex(index);
		deleteNode(node);
	}

	private void removeHead() {
		if (head.next == null) {
			head = null;
			tail = null;
		} else {
			Node<T> temp = head;
			head = head.next;
			head.prev = null;
			temp.next = null;
			temp = null;
		}
		size--;
	}

	private void removeTail() {
		if (tail.prev == null) {
			head = null;
			tail = null;
		} else {
			Node<T> temp = tail;
			tail = tail.prev;
			tail.next = null;
			temp.prev = null;
			temp = null;
		}
		size--;
	}

	public void reverse() {
		if (head.next != null) {
			Node<T> trav1 = tail;
			Node<T> trav2 = tail.prev;
			head = tail;
			while (trav2 != null) {
				Node<T> temp = trav2.prev;
				trav1.next = trav2;
				trav2.prev = trav1;
				trav1.prev = null;
				trav2.next = null;
				trav1 = trav2;
				trav2 = temp;
			}
			tail = trav1;
		}
	}

	public void reverseByReccursion() {
		tail = reverse(head, head.next);
	}

	private Node<T> reverse(Node<T> trav2, Node<T> trav1) {
		if (trav1 == null) {
			head = trav2;
			return trav2;
		}
		reverse(trav1, trav1.next);
		trav1.next = trav2;
		trav2.prev = trav1;
		trav1.prev = null;
		trav2.next = null;
		return trav2;
	}

	public static void main(String[] args) throws Exception {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		System.out.println(list);
		list.reverseByReccursion();
		System.out.println(list);
	}

}
