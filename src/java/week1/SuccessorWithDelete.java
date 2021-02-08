/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class SuccessorWithDelete {
    private WeightedQuickUnion wqu;

    public SuccessorWithDelete(int N) {
        wqu = new WeightedQuickUnion(N);
    }

    public static void main(String[] args) {
        SuccessorWithDelete swd = new SuccessorWithDelete(10);
        swd.delete(4);
        System.out.println(swd.successor(4));
        swd.delete(5);
        System.out.println(swd.successor(4));
        swd.delete(3);
        System.out.println(swd.successor(2));
    }

    public void delete(int x) {
        wqu.union(x, x + 1);
    }

    public int successor(int x) {
        return wqu.getActualSuccessor(x);
    }
}
