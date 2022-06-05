package learn.java.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class ArrayAlgorithmsTest {
    @Test
    public void testArray() {
        ArrayAlgorithms arrayAlgorithm = new ArrayAlgorithms();
        Assertions.assertThat(arrayAlgorithm.getIntegerArray()).hasSize(100_000);

    }

    @Test
    public void testArraySortedForkJoin() throws ExecutionException, InterruptedException {
        ArrayAlgorithms arrayAlgorithm = new ArrayAlgorithms();
        int[] integerArraySorted = arrayAlgorithm.getIntegerArraySorted();
        Assertions.assertThat(integerArraySorted).hasSize(100_000);
        Assertions.assertThat(arrayAlgorithm.isSortedForkJoin(integerArraySorted)).isTrue();

    }

    @Test
    public void testArrayNotSortedForkJoin() throws ExecutionException, InterruptedException {
        ArrayAlgorithms arrayAlgorithm = new ArrayAlgorithms();
        int[] integerArraySorted = arrayAlgorithm.getIntegerArray();
        Assertions.assertThat(integerArraySorted).hasSize(100_000);
        Assertions.assertThat(arrayAlgorithm.isSortedForkJoin(integerArraySorted)).isFalse();

    }

    @Test
    public void testArrayNotSortedSimple() throws ExecutionException, InterruptedException {
        ArrayAlgorithms arrayAlgorithm = new ArrayAlgorithms();
        int[] integerArraySorted = arrayAlgorithm.getIntegerArray();
        Assertions.assertThat(integerArraySorted).hasSize(100_000);
        Assertions.assertThat(arrayAlgorithm.isSortedSimple(integerArraySorted)).isFalse();

    }

    @Test
    public void testMergeSort() {
        ArrayAlgorithms arrayAlgorithm = new ArrayAlgorithms();
        int[] arr = new int[] {5,4,3,1,2};
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.sort();
    }

    @Test
    public void testQuickSort() {
        ArrayAlgorithms arrayAlgorithm = new ArrayAlgorithms();
        int[] arr = new int[] {5,4,3,1,2};
        QuickSort quickSort = new QuickSort(arr);
        quickSort.sort();
    }
}
