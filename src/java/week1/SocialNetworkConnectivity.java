/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class SocialNetworkConnectivity {
    private WeightedQuickUnion wqu;
    private int[] members;

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

        return wqu.getTreeSize() == members.length;
    }

    public void connect(int p, int q) {
        this.wqu.union(p, q);
    }

    public static void main(String[] args) {
        SocialNetworkConnectivity sn = new SocialNetworkConnectivity(5);
        sn.connect(1, 2);
        sn.connect(3, 4);
        sn.connect(0, 3);
        System.out.println(sn.areAllFriendsConnected());
        sn.connect(1, 3);
        System.out.println(sn.areAllFriendsConnected());
    }
}
