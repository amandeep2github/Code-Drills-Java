package learn.java.v8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Author: Dhiraj Gupta
* 
* Sort an array by element frequency
* Your customSort method should print the sorted (in order of non-decreasing frequency)
elements of array arr.
* If 2 or more elements have the same frequency, this subset of elements should be sorted in
non-decreasing order.
*
* Test Cases 1 :
* Input arr = {8, 5, 5, 5, 5, 1, 1, 1, 4, 4}
* Output arr = {8, 4, 4, 1, 1, 1, 5, 5, 5, 5 };
*
*/

public class CustomeSortingExa {

	public static void main(String  aa[]) {
		int[] arr = {8, 5, 5, 5, 5, 1, 1, 1, 4, 4};
	//	For Testing
	//	int[] arr = {7, 4, 4, 4, 4, 1, 1, 1, 3, 3};
	//	int[] arr = {9, 6, 6, 6, 6, 1, 1, 5, 5, 5};
		customSortArray(arr);
 		}
	
	
	 public static void customSortArray(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for (int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
			
			
			if (!list.contains(i)) {
				list.add(i);
			}
		}
		
		Collections.sort(list);
		
		List<Integer> val = new ArrayList<>(list);
		int count = 1;
		while(!val.isEmpty()) {
			val = printArray(val, map, count);
			count++;
		}

	}
	
	 static ArrayList<Integer> printArray(List<Integer> numbers, Map<Integer, Integer> map, int item) {
		ArrayList<Integer> outputList = new ArrayList<>();
		
		for (Integer integer : numbers) {
			if(map.get(integer) == item) {
				for (int i = 1; i <= item; i++) {
					System.out.println(integer);
				}
			} else {
				outputList.add(integer);
			}
		}
		
		return outputList;
	}
}
		


