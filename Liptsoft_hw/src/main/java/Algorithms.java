import java.util.ArrayList;
import java.util.Collections;

public class Algorithms {
    public static Boolean KnuthMorrisPratt(String pattern, String className, Boolean isBlankOnEndOfPattern) {
        String s = pattern + "#" + className;
        int sLength = s.length();
        ArrayList<Integer> pi = new ArrayList<>(Collections.nCopies(sLength, 0));

        for (int i = 1; i < sLength; i++ ) {
            if (s.charAt(i) == '#') {
                continue;
            }
            int j = pi.get(i - 1);
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi.get(j - 1);
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi.set(i, j);
            if (!isBlankOnEndOfPattern && i > pattern.length() && pi.get(i) == pattern.length()) {
                return true;
            }
        }
        return isBlankOnEndOfPattern && pi.get(sLength - 1) == pattern.length();
    }
}
