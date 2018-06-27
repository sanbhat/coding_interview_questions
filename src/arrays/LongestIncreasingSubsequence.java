package arrays;

/**
 * https://www.interviewbit.com/problems/longest-increasing-subsequence/
 * <p>
 * Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] 
 * <p>
 * Output : 6
 * <p>
 * The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 * @author santhosh
 *
 */
public class LongestIncreasingSubsequence {
	
	public int lis(int[] arr) {
		int n = arr.length;
		int t[] = new int[n];
		
		for(int i=0; i<n; i++) {
			t[i] = 1;
		}
		
		int max = -1;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && t[i] < t[j] + 1) {
					t[i] = t[j] + 1;
				}
			}
			if(t[i] > max) {
				max = t[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(new LongestIncreasingSubsequence().lis(arr));
	}

}
