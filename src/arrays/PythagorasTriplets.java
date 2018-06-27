package arrays;

import java.util.Arrays;

/**
 * Find triplets a,b,c such that a^2 = b^2 + c^2
 * <p>
 * The solution given below is nicely explained at - https://stackoverflow.com/a/2032765/991778 
 *
 */
public class PythagorasTriplets {

	
	public boolean findTriplets(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			arr[i] = arr[i] * arr[i];
		}
		
		Arrays.sort(arr);
		
		for(int i=n-1; i>0; i--) {
			int l = 0;
			int r = i-1;
			
			while(l < r) {
				if(arr[i] == arr[l] + arr[r]) {
					return true;
				} else if(arr[l] + arr[r] < arr[i]) {
					l++;
				} else {
					r--;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		PythagorasTriplets p = new PythagorasTriplets();
		System.out.println("1 - " + p.findTriplets(new int[]{3, 1, 4, 6, 5}));
		System.out.println("2 - " + p.findTriplets(new int[]{10, 4, 6, 12, 5}));
	}
}
