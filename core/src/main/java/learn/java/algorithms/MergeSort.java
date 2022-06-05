package learn.java.algorithms;

public class MergeSort {
    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arrToSort, int startx, int endx) {
        if (startx >= endx)
            return;
        int midx = (startx + endx - 1) / 2;

        mergeSort(arrToSort, startx, midx);
        mergeSort(arrToSort, midx+1, endx);


        int[] tempArr = new int[endx - startx + 1];
        int i = startx, j = midx+1, k = 0;
        while (i <= midx && j <= endx) {
            if (arrToSort[i] < arrToSort[j]) {
                tempArr[k++] = arrToSort[i++];
            } else {
                tempArr[k++] = arrToSort[j++];
            }
        }
        while (i <= midx) {
            tempArr[k++] = arrToSort[i++];
        }
        while (j <= endx) {
            tempArr[k++] = arrToSort[j++];
        }
        for (int m = 0; m <= endx-startx; m++) {
            arrToSort[startx+m] = tempArr[m];
        }
    }

    public int[] getArr() {
        return arr;
    }
}
