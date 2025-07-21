package com.solvd.course.collections;

public class CustomLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) head = node;
        else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = node;
        }
    }

    public T get(int index) {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) return current.data;
            current = current.next;
            count++;
        }
        throw new IndexOutOfBoundsException();
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1 && current.next != null) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
            count++;
        }
        throw new IndexOutOfBoundsException();
    }
}