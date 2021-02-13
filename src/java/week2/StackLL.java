/* *****************************************************************************
 *   @author - Raj Kumar Boddupally
 *   @created date = 02/12/2021
 **************************************************************************** */

package week2;

import java.util.NoSuchElementException;

public class StackLL {
    private Node head;
    private int size;

    public static void main(String[] args) {
        StackLL stack = new StackLL();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size " + stack.size());
        System.out.println(stack.pop());
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Node node = head;
        head = head.next;
        size--;
        return node.val;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
