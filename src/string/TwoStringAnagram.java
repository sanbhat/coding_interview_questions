package string;

/**
 * Two strings are called anagrams if one string can be rearranged to form another string
 * and vice-versa.
 */
public class TwoStringAnagram {


    boolean isAnagram(String s1, String s2) {
        //assuming only ascii chars
        int[] ascii = new int[256];

        for(int i=0; i<s1.length(); i++) {
            ascii[s1.charAt(i)]++;
        }

        for(int i=0; i<s2.length(); i++) {
            ascii[s2.charAt(i)]--;
        }

        for(int i=0; i<256; i++) {
            if(ascii[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";

        System.out.println(new TwoStringAnagram().isAnagram(s1, s2));

    }

}
