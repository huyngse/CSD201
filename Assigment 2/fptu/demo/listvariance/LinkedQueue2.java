/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptu.demo.listvariance;

import java.util.ArrayList;

/**
 *
 * @author vinhvo
 */
/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 */
public class LinkedQueue2<E extends Comparable<E>> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    private Node<E> rear, front;

    @Override
    public int size() {
        // write your code here
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        // write your code here
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        // write your code here
        list.addLast(e);
    }

    @Override
    public E first() {
        // write your code here
        return list.getFirst();
    }

    @Override
    public E dequeue() {
        // write your code here
        return list.removeFirst();
    }

    @Override
    public void reverse() {
        // write your code here
        ArrayList<E> newList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            newList.add(list.removeFirst());
        }
        for (int i = 0; i < size; i++) {
            list.addFirst(newList.get(i));
        }
    }

    public void display() {
        list.display();
    }
}
