package BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(mergeSort(numbers)).replaceAll("[\\[\\],]", ""));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int halfIndex = arr.length / 2;
        int[] firstPartition = new int[halfIndex];
        int[] secondPartition = new int[arr.length - halfIndex];

        System.arraycopy(arr, 0, firstPartition, 0, halfIndex);
        System.arraycopy(arr, halfIndex, secondPartition, 0, arr.length - halfIndex);
        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);
        int mainIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstPartition.length && secondIndex < secondPartition.length) {
            if (firstPartition[firstIndex] < secondPartition[secondIndex]) {
                arr[mainIndex] = firstPartition[firstIndex];
                firstIndex++;
            } else {
                arr[mainIndex] = secondPartition[secondIndex];
                secondIndex++;
            }
            mainIndex++;
        }
        while (firstIndex < firstPartition.length) {
            arr[mainIndex] = firstPartition[firstIndex];
            firstIndex++;
            mainIndex++;
        }
        while (secondIndex < secondPartition.length) {
            arr[mainIndex] = secondPartition[secondIndex];
            secondIndex++;
            mainIndex++;
        }
        return arr;
    }
}
