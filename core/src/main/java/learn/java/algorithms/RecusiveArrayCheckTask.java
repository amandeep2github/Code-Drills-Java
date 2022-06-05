package learn.java.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecusiveArrayCheckTask extends RecursiveTask<Boolean> {
    private final int startInx;
    private final int endInx;
    int[] arrayToCheck;
    int threshold;

    public RecusiveArrayCheckTask(int[] arrayToCheck, int threshold, int startInx, int endInx) {
        this.arrayToCheck = arrayToCheck;
        this.threshold = threshold;
        this.startInx = startInx;
        this.endInx = endInx;
    }

    @Override
    protected Boolean compute() {
        boolean sorted = true;
        if(threshold < endInx - startInx){
            List<RecusiveArrayCheckTask> subtasks = new ArrayList<>();
            int midInx = (endInx+startInx)/2;
            subtasks.add(new RecusiveArrayCheckTask(arrayToCheck, threshold, startInx, midInx-1));
            subtasks.add(new RecusiveArrayCheckTask(arrayToCheck, threshold, midInx, endInx));
//            this.join();
            for(RecusiveArrayCheckTask task: subtasks){
                task.fork();
            }
            for(RecusiveArrayCheckTask task: subtasks){
                if(!(sorted = task.join())){
                    break;
                }
            }

        }else{
            System.out.printf("Thread %s, StartInx - %d, endInx - %d\n", Thread.currentThread(), startInx, endInx);
            for(int i=startInx; i<endInx-1; i++) {
                if(arrayToCheck[i] > arrayToCheck[i+1]) {
                    sorted = false;
                    break;
                }
            }
        }
        return sorted;
    }
}