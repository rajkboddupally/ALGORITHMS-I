/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class SocialNetworkConnectivity {
    private WeightedQuickUnion wqu;
    //QuickFindUF
    private int[] members;
    private int earlistTime;

    public SocialNetworkConnectivity(int n) {
        this.wqu = new WeightedQuickUnion(n);
        this.members = wqu.getMembers();
    }

    public boolean areAllFriendsConnected() {

        /* Brute force
        for (int i = 1; i < members.length; i++) {
            if (!wqu.connected(members[i], members[i - 1])) {
                return false;
            }
        }
         */

        //logn as the tree is weighted and compressed.
        return wqu.getTreeSize() == members.length;
    }

    public void connect(int p, int q) {
        this.wqu.union(p, q);
        if (!areAllFriendsConnected())
            earlistTime++;
    }

    public int earliestTime() {
        return earlistTime;
    }

    public static void main(String[] args) {
        SocialNetworkConnectivity sn = new SocialNetworkConnectivity(7);
        sn.connect(1, 2);
        System.out.println(sn.find(1));
        sn.connect(3, 4);
        System.out.println(sn.find(4));
        sn.connect(0, 3);
        System.out.println(sn.find(0));
        //System.out.println(sn.areAllFriendsConnected() + " " + sn.earliestTime());
        sn.connect(1, 3);
        System.out.println(sn.find(1));
        sn.connect(5, 6);
        System.out.println(sn.find(5));
        System.out.println(sn.find(6));
        //System.out.println(sn.areAllFriendsConnected() + " " + sn.earliestTime());
    }

    public int find(int p) {
        return wqu.getMax(p);
    }
}
