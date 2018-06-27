package set;

public class SetForGivenArray {

	public void printSets(int[] arr) {
		int set[] = new int[arr.length];
		createSet(arr, set, 0);
	}

	private void createSet(int[] arr, int[] set, int i) {
		if(i == arr.length) {
			print(set);
			return;
		}
		set[i] = -1;
		createSet(arr, set, i + 1);
		set[i] = arr[i];
		createSet(arr, set, i + 1);
	} 
	
	private void print(int[] set) {
		String s = "{";
		boolean has = false;
		for(int i : set) {
			if(i != -1) {
				s += i + ",";
				has = true;
			}
		}
		if(has) s = s.substring(0, s.lastIndexOf(","));
		s += "}";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		SetForGivenArray sfga = new SetForGivenArray();
		sfga.printSets(new int[]{1, 2});
	}
}
