import algorithms.MergeSort;
import algorithms.QuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int[] vet = GenerateRandomArray.generate(size);
        int[] vet2 = GenerateRandomArray.generate(size);

        System.out.println(Arrays.toString(vet));

        long startTimeMerge = System.nanoTime();
        int swapCount = MergeSort.mergeSort(0, vet.length, vet);
        long endTimeMerge = System.nanoTime();
        long timeElapsedMerge = endTimeMerge - startTimeMerge;

        long startTimeQuick = System.nanoTime();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(vet2, 0, vet.length - 1);

        int swapCountQuick = quickSort.swapCount;
        long endTimeQuick = System.nanoTime();
        long timeElapsedQuick = endTimeQuick - startTimeQuick;

        System.out.println(Arrays.toString(vet));

        System.out.println("Quicksort: \n\tTime Elapsed: " + timeElapsedQuick + "\n\tSwap Count: " + swapCountQuick);
        System.out.println("Mergesort: \n\tTime Elapsed: " + timeElapsedMerge + "\n\tSwap Count: " + swapCount);

    }
}
