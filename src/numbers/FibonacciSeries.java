package numbers;

public class FibonacciSeries {

    public void fib(int max) {
        int n1 = 0, n2 = 1;
        int n3 = 0;
        System.out.print(n1 + " " + n2);
        for (int i = 2; i <= max; i++) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }

    public int fibNum(int n) {
        int[] f = new int[n+1];
        if(n <= 1) {
            return n;
        }
        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        FibonacciSeries f = new FibonacciSeries();
        f.fib(30);
        System.out.println();
        System.out.println(f.fibNum(9));
    }
}
