/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class QuickUnion {

    private int[] ids;

    public QuickUnion(int N) {
        this.ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        ids[pRoot] = qRoot;
    }

    public static void main(String[] args) {

    }
}
