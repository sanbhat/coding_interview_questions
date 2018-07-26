package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Replace each elements of an array with the nearest bigger element
 * which is on the right side.
 * 
 * @author santhosh
 *
 */
public class ReplaceElementWithNearestBigger {

	public void replace(int[] arr) {
		int n = arr.length;
		Stack<Integer> s = new Stack<>();
		for(int i=n-1; i >= 0; i--) {
			if(s.isEmpty()) {
				s.push(arr[i]);
			} else {
				List<Integer> temp = new ArrayList<>();
				while(!s.isEmpty() && !(arr[i] < s.peek())) {
					temp.add(s.pop());
				}
				int r = arr[i];
				arr[i] = s.peek();
				for(Integer k : temp) {
					s.push(k);
				}
				s.push(r);
			}
			
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 5, 6, 3, 4, 1, 2, 9, 11};
		new ReplaceElementWithNearestBigger().replace(arr);
		System.out.println(Arrays.toString(arr));
	}
}
