/* *****************************************************************************
 *  Name:              Raj
 *  Last modified:     02/12/2021
 **************************************************************************** */

package week2;

public class StackFixedCapacityString {
    private String[] stringArr;
    private int N;

    public StackFixedCapacityString(int capacity) {
        stringArr = new String[capacity];
    }

    public StackFixedCapacityString() {
        stringArr = new String[1];
    }

    public static void main(String[] args) {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String element) {
        if (N == stringArr.length) {
            resize(2 * N);
        }
        stringArr[N++] = element;
    }

    private void resize(int i) {
        String[] resizedArr = new String[i];
        for (int j = 0; j < N; j++) {
            resizedArr[j] = stringArr[j];
        }
        stringArr = resizedArr;
    }

    public String pop() {
        //loitering
        //return stringArr[--N];

        String val = stringArr[--N];
        stringArr[N] = null;

        if (N == stringArr.length / 4) {
            resize(N / 2);
        }

        return val;
    }
}
