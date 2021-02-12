/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

import java.util.Arrays;

/*
Question 1
3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n^2n
2
  in the worst case. You may assume that you can sort the nn integers in time proportional to n^2n
2
  or better.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { 4, 3, -2, 7, 2, 0, -3, 2, -4 };

        threeSum(arr);
    }

    private static void threeSum(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int startIndex = i + 1;
            int endIndex = arr.length - 1;

            while (startIndex < endIndex) {
                int sum = arr[i] + arr[startIndex] + arr[endIndex];
                if (sum > 0) {
                    endIndex--;
                }
                else if (sum < 0) {
                    startIndex++;
                }
                else {
                    System.out.println(arr[i] + ":" + arr[startIndex] + ":" + arr[endIndex]);
                    startIndex++;
                    endIndex--;
                }
            }
        }
    }
}
