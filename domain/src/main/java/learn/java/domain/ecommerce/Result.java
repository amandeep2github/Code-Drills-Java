package learn.java.domain.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> names = new ArrayList<>();
    private int totalMarks = 0;

    public Result() {
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public int addMarks(int marksToAdd) {
        return totalMarks + marksToAdd;
    }

    public List<String> addName(String name){
        names.add(name);
        return names;
    }
}
