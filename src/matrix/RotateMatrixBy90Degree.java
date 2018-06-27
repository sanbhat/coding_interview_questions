package matrix;

public class RotateMatrixBy90Degree {

	public int[][] rotate(int[][] m) {
		int n = m.length;
		int[][] result = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				result[n-1-j][i] = m[i][j];
			}
		}
		return result;
	}
	
	public int[][] rotateWithoutSpace(int[][] m) {
		int n = m.length;
		for(int i=0; i<n/2; i++) {
			for(int j=i; j< n-i-1; j++) {
				int temp = m[i][j];
				m[i][j] = m[j][n-1-i];
				m[j][n-1-i] = m[n-1-i][n-1-j];
				m[n-1-i][n-1-j] = m[n-1-j][i];
				m[n-1-j][i] = temp;
			}
		}
		return m;
	}

	private static void printMatrix(int[][] m) {
		int n = m.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(m[i][j]);
				if(i != n-1 || j != n-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] m = new int[n][n];
		int k = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				m[i][j] = k++;
			}
		}
		
		RotateMatrixBy90Degree r = new RotateMatrixBy90Degree();
		System.out.println("Input:");
		printMatrix(m);
		System.out.println("Output:");
		printMatrix(r.rotate(m));
		System.out.println();
		printMatrix(r.rotateWithoutSpace(m));
		System.out.println();
		
		n = 4;
		m = new int[n][n];
		k = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				m[i][j] = k++;
			}
		}
		
		System.out.println("Input:");
		printMatrix(m);
		System.out.println("Output:");
		printMatrix(r.rotate(m));
		System.out.println();
		printMatrix(r.rotateWithoutSpace(m));
		
		
	}
}
