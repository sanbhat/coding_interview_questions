package string;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.techiedelight.com/find-possible-palindromic-substrings-string/
 */
public class AllSubstringPalindromes {

    public Collection<String> findAllSubstringPalindromes(String s) {
        Set<String> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            expand(s, i, i, set);
            expand(s, i, i+1, set);
        }

        return set;
    }

    private void expand(String s, int low, int high, Set<String> set) {
        while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            set.add(s.substring(low, high + 1));
            low--;
            high++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllSubstringPalindromes().findAllSubstringPalindromes("abca"));
    }
}
