package arrays;

/**
 * Find the maximum difference between any 2 numbers in an array. The maximum of difference is found
 * for elements at any index <code>i, j</code> if <code>a[i] > a[j]</code> then <code>i > j</code> should be true.
 * <p>
 * <a href='https://www.geeksforgeeks.org/maximum-difference-between-two-elements/'>https://www.geeksforgeeks.org/maximum-difference-between-two-elements/</a>
 * 
 * @author santhosh
 *
 */
public class MaxDifferenceBetween2Numbers {
	
	public int maxDiff(int[] a) {
		int n = a.length;
		if(n == 1) {
			return -1;
		}
		
		int maxDiff = a[1] - a[0];
		int min = a[0];
		for(int i=1; i<n; i++) {
			if(a[i] - min > maxDiff) {
				maxDiff = a[i] - min;
			}
			if(a[i] < min) {
				min = a[i];
			}
		}
		
		return maxDiff > 0 ? maxDiff : -1;
	}

	public static void main(String[] args) {
		MaxDifferenceBetween2Numbers m = new MaxDifferenceBetween2Numbers();
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(m.maxDiff(arr));
		
		arr = new int[]{7, 9, 5, 6, 3, 2};
		System.out.println(m.maxDiff(arr));
		
		arr = new int[]{17, 6, 5, 4, 3, 2};
		System.out.println(m.maxDiff(arr));
	}
}
