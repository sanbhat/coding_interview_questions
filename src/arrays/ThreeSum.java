package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * find a, b, c such that a + b + c = k
	 * a + b = k - c
	 */
	public List<int[]> getThreeSum(int[] arr, int sum) {
		List<int[]> result = new ArrayList<>();
		
		Arrays.sort(arr);
		
		int n = arr.length;
		int[] aux = new int[n];
		for(int i=0; i<n; i++) {
			aux[i] = sum - arr[i];
		}
		
		for(int i=n-1; i>0; i--) {
			
			int l = 0;
			int r = i-1;
			
			while(l < r) {
				if(arr[l] + arr[r] == aux[i]) {
					result.add(new int[]{arr[l], arr[r], sum - aux[i]});
					break;
				} else if(arr[l] + arr[r] < aux[i]) {
					l++;
				} else {
					r--;
				}
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		List<int[]> result = t.getThreeSum(new int[]{-1, 0, 1, 2, 3, -5, 10, 7, 8}, 0);
		
		for(int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
		
	}
}
