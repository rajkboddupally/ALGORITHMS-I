/* *****************************************************************************
@author - Raj Kumar Boddupally
@created date = 02/12/2021
 **************************************************************************** */

package week1;

public class BitonicArraySearch2LogN {
    public static void main(String[] args) {
        int[] arr = { -3, 4, 9, 10, 18, 19, 20, 17, 6, 5, 1 };
        int key = 5;
        boolean isPresent = bitonicSearch(arr, 0, arr.length - 1, key);
        System.out.println("is Key " + key + " present in bitonic arr " + isPresent);
    }


    private static boolean bitonicSearch(int[] arr, int startIndex, int endIndex, int key) {

        int mid = startIndex + (endIndex - startIndex) / 2;

        if (arr[mid] == key) {
            System.out.println("Key found at Index " + mid);
            return true;
        }

        if (arr[mid] > arr[mid - 1]) {
            if (key < arr[mid]) {
                return binarySearchAsc(arr, startIndex, mid, key) || binarySearchDesc(arr, mid + 1,
                                                                                      endIndex,
                                                                                      key);
            }
            else {
                return bitonicSearch(arr, mid + 1, endIndex, key);
            }
        }
        else {
            if (key < arr[mid]) {
                return binarySearchAsc(arr, startIndex, mid, key) || binarySearchDesc(arr, mid + 1,
                                                                                      endIndex,
                                                                                      key);
            }
            else {
                return bitonicSearch(arr, startIndex, mid, key);
            }
        }
    }

    private static boolean binarySearchAsc(int[] arr, int startIndex, int endIndex, int key) {

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (arr[mid] > key) {
                endIndex = mid - 1;
            }
            else if (arr[mid] < key) {
                startIndex = mid + 1;
            }
            else {
                System.out.println("binarySearchAsc Key present at index " + mid);
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearchDesc(int[] arr, int startIndex, int endIndex, int key) {

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (arr[mid] < key) {
                endIndex = mid - 1;
            }
            else if (arr[mid] > key) {
                startIndex = mid + 1;
            }
            else {
                System.out.println("binarySearchDesc Key present at index " + mid);
                return true;
            }
        }
        return false;
    }
}
