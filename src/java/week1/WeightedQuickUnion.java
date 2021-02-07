/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class WeightedQuickUnion {
    private int[] ids;
    private int[] sz;

    public WeightedQuickUnion(int N) {
        this.ids = new int[N];
        this.sz = new int[N];

        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public boolean union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (pRoot == qRoot)
            return false;

        if (sz[pRoot] > sz[qRoot]) {
            ids[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        else {
            ids[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        return true;
    }

    private int root(int i) {
        while (i != ids[i]) {
            i = ids[i];
            ids[i] = ids[ids[i]];
        }
        return i;
    }

    public int[] getMembers() {
        return this.ids;
    }

    public int getTreeSize() {
        int root = root(ids[0]);
        return this.sz[root];
    }

    public static void main(String[] args) {

    }
}
