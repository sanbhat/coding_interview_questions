package numbers;

public class FindMissingNumberInIncreasingArray {

    public static int findMissing(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        while(l < h) {
            mid = l + (h - l) / 2;
            if((arr[l]-l) != (arr[mid]-mid)) {
                h = mid;
            }
            else if((arr[h]-h) != (arr[mid]-mid)) {
                l = mid;
            }
        }
        return arr[mid]+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2,  4, 5};
        System.out.println(findMissing(arr));
    }
}
