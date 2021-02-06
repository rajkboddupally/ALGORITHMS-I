package week1;

public class QuickFind {

    private final int[] id;

    public QuickFind(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pValue = id[p];
        int qValue = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pValue) {
                id[i] = qValue;
            }
        }
    }
}
