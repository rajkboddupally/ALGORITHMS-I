/* *****************************************************************************
 *  Name:              Raj
 *  Last modified:     02/13/2021
 **************************************************************************** */

package week2;

public class LinkedQueue<T> {

    private Node first, last;

    public static void main(String[] args) {
        LinkedQueue<Integer> lq = new LinkedQueue<>();
        lq.enqueue(1);
        lq.enqueue(2);
        System.out.println(lq.deque());
        lq.enqueue(3);
        System.out.println(lq.deque());
        lq.enqueue(4);
    }

    public void enqueue(T data) {
        Node oldLast = last;
        last = new Node();
        last.data = data;
        last.next = null;

        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
    }

    public T deque() {
        Node firstNode = first;

        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        return firstNode.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        T data;
        Node next;
    }
}
