/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package week1;

public class BitonicArraySearch {
    public static void main(String[] args) {
        int[] arr = { -3, 4, 9, 10, 18, 19, 20, 17, 6, 5, 1 };
        int key = 17;
        // boolean isPresent = bitonicSearch(arr, key);
        boolean isPresent = binarySearch(arr, 0, arr.length - 1, key);
        System.out.println("is Key " + key + " present in bitonic arr " + isPresent);
    }

    private static boolean binarySearch(int[] arr, int startIndex, int endIndex,
                                        int key) {

        while (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (arr[mid] < key) {
                startIndex = mid + 1;
            }
            else if (arr[mid] > key) {
                endIndex = mid + (endIndex - mid) / 2;
            }
            else {
                System.out.println("binarySearch Key present at index " + mid);
                return true;
            }

        }
        return false;
    }

    private static boolean bitonicSearch(int[] arr, int key) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int maxElementIndex = 0;

        while (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                startIndex = mid + 1;
            }
            else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                endIndex = mid - 1;
            }
            else {
                maxElementIndex = mid;
                break;
            }
        }
        System.out.println(
                "Max element index " + maxElementIndex + ". Element " + arr[maxElementIndex]);
        if (arr[maxElementIndex] == key) {
            return true;
        }
        /*
        return binarySearchAsc(arr, 0, maxElementIndex, key) || binarySearchDesc(arr,
                                                                                 maxElementIndex
                                                                                         + 1,
                                                                                 arr.length, key);

         */
        return binarySearch(arr, 0, arr.length - 1, key);
    }

    private static boolean binarySearchAsc(int[] arr, int startIndex, int endIndex, int key) {

        while (startIndex < endIndex) {
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

        while (startIndex < endIndex) {
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
