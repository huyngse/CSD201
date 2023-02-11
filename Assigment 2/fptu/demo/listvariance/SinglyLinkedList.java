/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fptu.demo.listvariance;

import java.util.*;

/**
 *
 * @author vinhvo
 */

public class SinglyLinkedList<E extends Comparable<E>> implements Cloneable{
    
    // Define one node of the linked list
    private static class Node<E extends Comparable<E>> implements Comparable<E>{
        // Each node has two attributes
        private E element;      // 1. Data fields
        private Node<E> next;   // 2. Link to the next node

        // Constructors with two parameters
        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }

        public E getElement() {
            return this.element;
        }
        
        public void setElement(E e) {
            this.element = e;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }
        
        @Override
        public int compareTo(E that) {
        
            return this.getElement().compareTo(that);
        }
    }// End of the class Node<E>

    // Declare class attributes of the class SinglyLinkedList
    private Node<E> head = null;    // 1. the fisrt node of the list
    private Node<E> tail = null;    // 2. the final node of the list
    private int size = 0;           // 3. the number of nodes in the list

    // Default constructor
    public SinglyLinkedList() {
    }

    public int size() {
        return this.size;
    }

    public void setSize(int inSize){
        this.size = inSize;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }

    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        
        return head.getElement();
    }

    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        
        return tail.getElement();
    }

    /**
     * Visit all nodes and print data in each node on screen
     */
    public void display() {      
            
        // The list is empty
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        
        // Node current will point to head    
        Node current = head;  
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node's data then move to the next node    
            System.out.print(current.getElement() + " ");    
            current = current.getNext();    
        }    
        
        System.out.println();    
    }   
    
    
    // Following is a group of methods for updating the list
    
    /**
     * add the new node into the first position of the list
     * @param e the data field inside a node that will be added into the list
     */
    public void addFirst(E e) {
        head = new Node(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }    

    /**
     * add the new node into the last position of the list
     * @param e the data field inside a node that will be added into the list
     */
    public void addLast(E e) {
        // Define a new node, named 'newest', with data = e and link = null
        Node<E> newest = new Node(e, null);
        
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        
        // update the attribute 'tail' to newest
        tail = newest;
        
        // increase the attribute 'size' by 1
        size++;
    }

    /**
     * remove the first node which is hold by 'head' of the list
     * @return the data field of deleted node
     */
    public E removeFirst() {
        
        // The list is empty
        if (isEmpty()) {
            return null;
        }
        
        E answer = head.getElement();
        head = head.getNext();
        
        size--;
        if (size == 0) {
            tail = null;
        }
        
        return answer;
    }
    
    /**
     * remove the last node which is hold by 'tail' of the list
     * @return the data field of deleted node
     */
    public Node removeLast()
    {
        // The list is empty
        if (isEmpty())
            return null;
        // The list has only one node
        if (this.size == 1) {
            Node answer = head;
            head = tail = null;
            this.size--;
            return answer;
        }
        // The list node is >= 2
        // Find the second last node (the node before tail node)
        Node current = head;
        //Loop through the list untill reaching the second last node 
        while(current.next != tail) {  
            current = current.next;
        }
        // The second last node becomes new tail of the list  
        Node answer = tail;
        tail = current;  
        tail.next = null;  
        this.size--;
        
        return answer;
    }
    
    /**
     * find and return the entire node with given data
     * @param e data for search a node
     * @return the entire node that has data = e
     */
    public Node<E> getNode(E e) {
        for(Node <E> n = head; n != null; n = n.getNext()) // getNext() is in class Node
            if (n.getElement().equals(e)) // getElement() is in class Node
                return n;
        
        return null;
    }
    
    /**
     * Add the new node with data = e into after the 'current' node of the list
     * @param current the new node will be added after this node 
     * @param e data field inside the new node
     */
    public void addAfter(Node<E> current, E e) {
        
        if (current != null) { 
            current.setNext(new Node(e,current.getNext()));
            
            if (current == tail)  
                tail = current.getNext();
            
            size++;
        } else // insert new node into the list's front
            addFirst(e);
    }
    
    /**
     * remove the node after the current node in the list
     * @param current the node after 'current' node will be removed
     * @return data field inside the new node
     */
    public E removeAfter(Node <E> current){
        E temp;
        if (current != null) {  
		Node <E> nextPtr = current.getNext();
		if (nextPtr != null) {
                temp = nextPtr.getElement();
                current.setNext(nextPtr.getNext());
                this.size--;
                if (nextPtr.getNext() == null) // last node is removed
                    tail = current;
                return temp;
            } else 
                return null;
        } else // if current == null, then remove head
            return removeFirst();
    }

    /**
     * remove the node with data e from the list
     * @param e data of the removed node
     * @return 
     */
    public void remove(E e){
        Node<E> curr = this.head;
        Node<E> prev = null;
        
        // scan until locate node or reach the end of the list
        while (curr != null) {
            // have a match 
            if (curr.getElement().equals(e)) {

                if (prev == null) // curr is first node: just start to next
                    this.head = curr.getNext();
                
                else // make prev point to next
                    prev.setNext(curr.getNext());
                
                break;
            } else {
                // move curr and prev to the next node
                prev = curr;
                curr = curr.getNext();
            }
        }
        
        // Decrease size by 1
        if (size > 0)
            this.size--;
    }

    /**
     * Override the method equals() from class 'Object'
     * Two SSLs, listA and listB, are considered to be equal if 
     *    listA.size() = listB.size()
     *    Each node's data must be identical according to their corresponding positions
     * @param obj the list to be compared with 'this' list
     * @return true if two lists are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) 
            return false;
        
        if (this.getClass() != obj.getClass()) 
            return false;
        
        SinglyLinkedList other = (SinglyLinkedList) obj;  // use nonparameterized type // raw types
        if (this.size() != other.size()) 
            return false;
        
        Node walkA = this.head;  // traverse the primary list
        Node walkB = other.head;  // traverse the secondary list
        
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))  
                return false;
            
            // move walkA and walkB one node ahead
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        
        // if we reach here, everything matched exactly
        return true;  
    }

    /**
     * Override the clone() from Cloneable interface to 
     * make a deep copy of the current SLL
     * @return the copy SLL
     * @throws CloneNotSupportedException 
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        // always use inherited Object.clone() to create the initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();  // safe cast
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        
        // update the size of deep copy list
        other.setSize(this.size());
        
        return other;
    }
   
    // sortList() will sort a nodes in the list in ascending order
    public void sortList() {
        // Node current will point to head
        Node current = head, index = null;
  
        if (head != null) {
            while (current != null) {
                // Node index will point to node next to current
                index = current.getNext();
 
                while (index != null) {
                    // If current node's data is greater than index's node data,
                    // then swap the data between them
                    if (current.compareTo(index.getElement()) < 0) {
                        E temp = (E) current.getElement();
                        current.setElement(index.getElement());
                        index.setElement(temp);
                    }
                    
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }
} // End class SinglyLinkedList<E>

