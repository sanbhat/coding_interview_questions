package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
public class FindAllPrimeNumbersInRange {

    public List<Integer> find(int n) {
        boolean[] isPrime = new boolean[n+1];

        for(int i=0; i<n; i++) {
            isPrime[i] = true;
        }

        for(int factor=2; factor*factor <= n; factor++) {
            if(isPrime[factor]) {
                for(int j=factor; j*factor <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private int findNextK(boolean[] arr, int prev, int ki) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] && i > ki) {
                return prev + i;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllPrimeNumbersInRange().find(30));
    }
}
