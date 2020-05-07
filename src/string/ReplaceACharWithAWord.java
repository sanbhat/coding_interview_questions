package string;

/**
 * The trick here is to replace a single character's occurrences in a string
 * with a word or multiple characters
 */
public class ReplaceACharWithAWord {

    public String complexReplace(String input, char toReplace, String replacement) {
        int n = input.length();
        int o = 0;
        for(int i=0; i<n; i++) {
            if(input.charAt(i) == toReplace) {
                o++;
            }
        }
        int newLength = n + (o * replacement.length()) - o;
        char[] arr = new char[newLength];
        int rn = replacement.length();
        for(int i=n-1; i >= 0;  i--) {
            if(input.charAt(i) == toReplace) {
                for(int j=rn - 1; j >= 0; j--) {
                    arr[--newLength] = replacement.charAt(j);
                }
            } else {
                arr[--newLength] = input.charAt(i);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceACharWithAWord()
                .complexReplace("santhosh  bhat", ' ', "ved"));
    }

}
