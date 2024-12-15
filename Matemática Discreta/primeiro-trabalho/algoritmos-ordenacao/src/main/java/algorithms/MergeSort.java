package algorithms;
public class MergeSort {
    public static int mergeSort(int start, int end, int[] vet) {
        int swapCount = 0;
        if (start < end - 1) {
            int meio = (start + end) / 2;
            swapCount += mergeSort(start, meio, vet);
            swapCount += mergeSort(meio, end, vet);
            swapCount += intercalate(vet, start, meio, end);
        }
        return swapCount;
    }
    public static int intercalate(int[] vet, int start, int mid, int end) {
        int[] newVet = new int[end - start];
        int i = start;
        int m = mid;
        int pos = 0;
        int swapCount = 0;
        while (i < mid && m < end) {
            if (vet[i] <= vet[m]) {
                newVet[pos] = vet[i];
                pos = pos + 1;
                i = i + 1;
            } else {
                newVet[pos] = vet[m];
                pos = pos + 1;
                m = m + 1;
                swapCount++;
            }
        }
        while (i < mid) {
            newVet[pos] = vet[i];
            pos = pos + 1;
            i = i + 1;
        }
        while (m < end) {
            newVet[pos] = vet[m];
            pos = pos + 1;
            m = m + 1;
        }
        for (pos = 0, i = start; i < end; i++, pos++) {
            vet[i] = newVet[pos];
        }
        return swapCount;
    }
}
