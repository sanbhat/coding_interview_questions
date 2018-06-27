package arrays;

import java.util.Stack;

public class NextGreaterElement {
	
	
	/**
	 * This method is a non-efficient way of finding NGE, for each element within the array. The worst case
	 * complexity of this method is O(n^2). Steps
	 * <ul>
	 * 	<li>Iterate through each elements within the array - with index - <code>i</code>
	 *  <li>For each element, start another iteration, where index is greater than <code>i</code> call it <code>j</code>
	 *  <li>If we get an element <code>a[j]</code> such that, <code>a[j] > a[i]</code>, then break.
	 *  <li>At this point <code>a[j]</code> is the NGE for <code>a[i]</code>
	 * </ul>
	 * @param arr
	 */
	public void nge(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			if(i == n-1) {
				System.out.print(arr[i] + "'s NGE -> -1");
			} else {
				boolean found = false;
				for(int j=i+1; j<n; j++) {
					if(arr[j] > arr[i]) {
						System.out.print(arr[i]+ "'s NGE -> " +arr[j]);
						found = true;
						break;
					}
				}
				if(!found) {
					System.out.print(arr[i]+ "'s NGE -> -1");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Using {@link Stack}, the efficiency of the algorithm can be improved drastically. Steps -
	 * <ul>
	 * 		<li> If the stack is empty, or if the current element is &lt;= stack's top, then insert the element into the stack.
	 * 		<li> If the current element is &gt; than stack's top, then pop all the elements from the stack which are &lt; current
	 * 		<li> Assign current element as the NGE of the popped elements
	 * 		<li> Push current element into the stack and continue
	 * </ul>
	 * @param arr
	 */
	public void ngeStack(int[] arr) {
		int n = arr.length;
		int c = 0;
		
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<n; i++) {
			c++;
			if(s.isEmpty()) {
				s.push(arr[i]);
			} else  {
				while(!s.isEmpty() && s.peek() < arr[i]) {
					c++;
					int a = s.pop();
					System.out.println(a + " -> " + arr[i]);
				}
				s.push(arr[i]);
			} 
		}
		while(!s.isEmpty()) {
			c++;
			System.out.println(s.pop() + " -> -1");
		}
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		NextGreaterElement nge = new NextGreaterElement();
		nge.nge(new int[]{6, 4, 7, 5, 2, 8, 25, 7, 4});
		nge.ngeStack(new int[]{6, 4, 7, 5, 2, 8, 25, 7, 4});
	}

}
