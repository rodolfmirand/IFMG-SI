package algorithms;
public class QuickSort {
    public int swapCount;
    public void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int p = part(v, left, right);
            quickSort(v, left, p);
            quickSort(v, p + 1, right);
        }
    }
    public int part(int[] v, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = v[mid];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (v[i] < pivot);
            do {
                j--;
            } while (v[j] > pivot);
            if (i >= j) {
                return j;
            }
            int aux = v[i];
            v[i] = v[j];
            v[j] = aux;
            this.swapCount++;
        }
    }
}
