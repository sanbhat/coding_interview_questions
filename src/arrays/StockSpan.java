package arrays;

import java.util.Arrays;
import java.util.Stack;

import javafx.util.Pair;

public class StockSpan {
	
	public int[] stockSpan(int[] arr) {
		int n = arr.length;
		int[] res = new int[n];
		int c = 0;
		for(int i=0; i<n; i++) {
			c++;
			res[i] = 1;
			for(int j=i-1; j>=0; j--) {
				c++;
				if(arr[j] < arr[i]) {
					res[i]++;
				} else {
					break;
				}
			}
		}
		System.out.println(c);
		return res;
	}
	
	public int[] stockSpanEfficient(int[] arr) {
		int n = arr.length;
		int[] res = new int[n];
		int c = 0;
		Stack<Pair<Integer, Integer>> s = new Stack<>();
		for(int i=0; i<n; i++) {
			c++;
			if(s.isEmpty()) {
				s.push(new Pair<>(arr[i] , 1));
				res[i] = 1;
			} else {
				int v = 0;
				Pair<Integer, Integer> top = s.peek();
				if(arr[i] > top.getKey()) {
					v += top.getValue();
					while(arr[i] > top.getKey()) {
						c++;
						s.pop();
						top = s.peek();
						v += top.getValue();
					}
					s.push(new Pair<>(arr[i], v));
					res[i] = v;
				} else {
					s.push(new Pair<>(arr[i], 1));
					res[i] = 1;
				}
			}
		}
		System.out.println(c);
		return res;
	}
	
	public static void main(String[] args) {
		StockSpan s = new StockSpan();
		System.out.println(Arrays.toString(
				s.stockSpan(new int[]{100, 80, 60, 70, 60, 75, 85})));
		System.out.println(Arrays.toString(
				s.stockSpanEfficient(new int[]{100, 80, 60, 70, 60, 75, 85})));
	}

}
