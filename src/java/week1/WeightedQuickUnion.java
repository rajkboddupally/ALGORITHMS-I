

package week1;

public class WeightedQuickUnion {
    private int[] ids;
    private int[] sz;
    private int[] max;
    //Actual list is needed when client call delete method union(x, x+1)..
    // where sz[root(x)] > sz[root(x+1)]. As per weighted, program adds x+1 to x, but x is what client is asking to delete
    private int[] actualList;

    public WeightedQuickUnion(int N) {
        this.ids = new int[N];
        this.sz = new int[N];
        this.max = new int[N];
        this.actualList = new int[N];

        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sz[i] = 1;
            max[i] = i;
            actualList[i] = i;
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
            //this is needed to keep a copy x+1 as client calls successor which calls actualList[root(x+1)]
            actualList[pRoot] = qRoot;
        }
        else {
            ids[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        if (ids[pRoot] > ids[qRoot]) {
            max[pRoot] = ids[pRoot];
        }
        else {
            max[qRoot] = ids[qRoot];
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


    public int getMax(int p) {
        int root = root(p);
        return max[root];
    }

    public int getActualSuccessor(int x) {
        return actualList[root(x + 1)];
    }

    public static void main(String[] args) {

    }
}
