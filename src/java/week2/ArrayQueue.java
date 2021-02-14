/* *****************************************************************************
 *  Name:              Raj
 *  Last modified:     02/13/2021
 **************************************************************************** */

package week2;

public class ArrayQueue<T> {
    private T[] queue;
    private int N;
    private int startIndex;

    public ArrayQueue(int size) {
        this.queue = (T[]) new Object[size];
    }

    public ArrayQueue() {
        this.queue = (T[]) new Object[1];
    }

    public static void main(String[] args) {

        ArrayQueue<String> ar = new ArrayQueue<>();
        ar.enqueue("hello");
        ar.enqueue("welcome");
        System.out.println("size 2 " + ar.size());
        System.out.println(ar.deque());
        ar.enqueue("to");
        ar.enqueue("Arrayqueue");
        System.out.println("size 3 " + ar.size());
        System.out.println(ar.deque());
        System.out.println(ar.deque());
        System.out.println("size 1 " + ar.size());
    }

    public void enqueue(T data) {
        if (N == queue.length) {
            resize(2 * N);
        }
        queue[N++] = data;
    }

    public int size() {
        return N - startIndex;
    }

    public T deque() {

        T data = queue[startIndex];
        queue[startIndex] = null;
        startIndex++;

        if (startIndex > 0.75 * N) {
            resize(N / 2);
        }

        return data;
    }

    private void resize(int i) {
        T[] newArr = (T[]) new Object[i];
        int newCounter = 0;
        for (int j = 0; j < N; j++) {
            if (queue[j] != null)
                newArr[newCounter++] = queue[j];
        }
        N = newCounter;
        startIndex = 0;
        queue = newArr;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
