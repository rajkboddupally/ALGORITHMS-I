

package week1;

import edu.princeton.cs.algs4.StdIn;

public class QuickFindClient {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind qf = new QuickFind(N);
        qf.union(1, 2);
        qf.union(6, 7);
        qf.union(6, 2);
        System.out.println(qf.connected(1, 6));

    }
}
