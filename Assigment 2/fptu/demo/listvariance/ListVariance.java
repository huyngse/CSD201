/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fptu.demo.listvariance;

/**
 *
 * @author vinhvo
 */
public class ListVariance {

    public static void testStack(){
        // write your code here to test methods of stack
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.toString();
        System.out.println("Is stack empty?: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.top());
        System.out.println("Pop element: " + stack.pop());
        stack.toString();
        System.out.println("After Reverse: ");
        stack.reverse();
        stack.toString();
    }
    
    public static void testQueue(){
        // write your code here to test methods of queue
        System.out.println("________________________________________________________");
        System.out.println("TESTING QUEUE #1");
        LinkedQueue1 queue1 = new LinkedQueue1();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);
        queue1.enqueue(5);
        queue1.display();
        System.out.println("Is queue1 empty?: " + queue1.isEmpty());
        System.out.println("Qeue1 size: " + queue1.size());
        System.out.println("First element: " + queue1.first());
        System.out.println("Dequeue: " + queue1.dequeue());
        queue1.display();
        System.out.println("After Reverse: ");
        queue1.reverse();
        queue1.display();
         System.out.println("________________________________________________________");
        System.out.println("TESTING QUEUE #2");
        LinkedQueue2 queue2 = new LinkedQueue2();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);
        queue2.enqueue(5);
        queue2.display();
        System.out.println("Is queue2 empty?: " + queue2.isEmpty());
        System.out.println("Qeue2 size: " + queue2.size());
        System.out.println("First element: " + queue2.first());
        System.out.println("Dequeue: " + queue2.dequeue());
        queue2.display();
        System.out.println("After Reverse: ");
        queue2.reverse();
        queue2.display();
    }
    
    public static void main(String[] args) {
        
        System.out.println("Test methods of stack");
        testStack();

        System.out.println("Test methods of queue");
        testQueue();
    }
}
