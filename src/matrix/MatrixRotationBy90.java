package matrix;

public class MatrixRotationBy90 {

    /**
     * This method uses O(n) space complexity, an efficient solution would
     * be to use O(1) space complexity
     * @param input
     * @return
     */
    public int[][] rotateBy90(int[][] input) {
        int n = input.length;
        int[][] output = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int k = (n - 1) - i;
                output[i][j] = input[j][k];
            }
        }
        return output;
    }

    /**
     * The efficient solution
     * @param args
     */
    public int[][] rotateBy90(int[][] m, int n) {
        for(int layer=0; layer < n/2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i=first; i<last; ++i) {
                int offset = i - first;
                //save top
                int top = m[first][i];
                //left --> top
                m[first][i] =  m[last-offset][first];
                //bottm --> left
                m[last-offset][first] = m[last][last-offset];
                //right --> bottom
                m[last][last-offset] = m[i][last];
                //top --> right
                m[i][last] = top;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println("Input-");
        print(arr);
        System.out.println("\nOutput-");
        arr = new MatrixRotationBy90().rotateBy90(arr,4);
        print(arr);
    }

    private static void print(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j< n; j++) {
                System.out.print(arr[i][j]);
                if(j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
