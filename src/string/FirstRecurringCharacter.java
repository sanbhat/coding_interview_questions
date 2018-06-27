package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {
	
	
	public Character firstRecurringChar1(String input) {
		Set<Character> set = new HashSet<>();
		for(char c : input.toCharArray()) {
			if(!set.add(c)) {
				return c;
			}
		}
		return null;
 	}
	
	
	public static void main(String[] args) {
		FirstRecurringCharacter frc = new FirstRecurringCharacter();
		System.out.println(frc.firstRecurringChar1("ABCA"));
		System.out.println(frc.firstRecurringChar1("BCABA"));
		System.out.println(frc.firstRecurringChar1("ABC"));
		System.out.println(frc.firstRecurringChar1("ABBA"));
	}

}
