package com.solvd.laba.service;


import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public CustomLinkedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        } else {
            current.next = current.next.next;
            return true;
        }
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> current = head;

        while(current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
