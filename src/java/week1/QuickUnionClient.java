/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class QuickUnionClient {
    public static void main(String[] args) {
        QuickUnion qf = new QuickUnion(10);
        qf.union(1, 2);
        qf.union(6, 7);
        qf.union(6, 9);
        System.out.println(qf.connected(9, 4));

    }
}
