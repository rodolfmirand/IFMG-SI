import algorithms.MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int[] vet = GenerateRandomArray.generate(size);

        System.out.println(Arrays.toString(vet));

        long startTime = System.nanoTime();
        int swapCount = MergeSort.mergeSort(0, vet.length, vet);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println(Arrays.toString(vet));
        System.out.println("Time Elapsed: " + timeElapsed + "\nSwap Count: " + swapCount);
    }
}
