package learn.java.algorithms;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ArrayAlgorithms {
    int[] arrayToSort = {};

    public ArrayAlgorithms() {
        init();
    }

    private void init() {
//        IntStream.rangeClosed(1,100_0000).forEach();
        arrayToSort = new int[100_000];
        Random random = new Random();
        for(int i=0; i< 100_000; i++) {
            arrayToSort[i] = random.nextInt(10000);
        }
    }

    public int[] getIntegerArray() {
        return arrayToSort;
    }

    public int[] getIntegerArraySorted() {
        int[] sortedArray = new int[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, sortedArray, 0, arrayToSort.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public boolean isSortedForkJoin(int[] arrayToCheck) throws ExecutionException, InterruptedException {
        int threshold = 10000;
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        long start = System.nanoTime();
        ForkJoinTask<Boolean> submit = forkJoinPool.submit(new RecusiveArrayCheckTask(arrayToCheck, threshold, 0, arrayToCheck.length-1));
        Boolean sorted = submit.get();
        System.out.println("time spent - "+ TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
        return sorted;
    }
    public boolean isSortedSimple(int[] arrayToCheck) throws ExecutionException, InterruptedException {
        boolean sorted = true;
        long start = System.nanoTime();
        for(int i=0; i < arrayToCheck.length-1; i++){
            if(arrayToCheck[i] > arrayToCheck[i+1]) {
                sorted = false;
                break;
            }
        }
        System.out.println("time spent - "+ TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
        return sorted;
    }
}
