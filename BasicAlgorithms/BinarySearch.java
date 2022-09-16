package BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchedNumber = Integer.parseInt(scan.nextLine());
        System.out.println(getIndex(numbers, searchedNumber));
    }

    private static int getIndex(int[] arr, int searchedNumber) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (searchedNumber < arr[mid]) {
                end = mid - 1;
            } else if (searchedNumber > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
