public class Matcher {
    static Boolean matches(String className, String pattern, Boolean isBlankOnEndOfPattern) {
        int indexPattern = 0;
        int indexClass = 0;

        if (pattern.toLowerCase().equals(pattern)) {
            String classNameInLowerCase = className.toLowerCase();

            if (!pattern.contains("*") && Algorithms.KnuthMorrisPratt(pattern, classNameInLowerCase, isBlankOnEndOfPattern)) {
                return true;
            }

            while (indexPattern < pattern.length() && indexClass < className.length()) {
                if (pattern.charAt(indexPattern) == classNameInLowerCase.charAt(indexClass)) {
                    indexPattern++;
                    indexClass++;
                } else if (pattern.charAt(indexPattern) == '*') {
                    indexPattern++;
                    indexClass++;
                } else {
                    while (indexClass < className.length()
                            && (classNameInLowerCase.charAt(indexClass) != pattern.charAt(indexPattern)
                            || Character.isLowerCase(className.charAt(indexClass)))) {
                        indexClass++;
                    }
                }
            }
        } else {
            if (!pattern.contains("*") && Algorithms.KnuthMorrisPratt(pattern, className, isBlankOnEndOfPattern)) {
                return true;
            }

            while (indexPattern < pattern.length() && indexClass < className.length()) {
                if (pattern.charAt(indexPattern) == className.charAt(indexClass)) {
                    indexPattern++;
                    indexClass++;
                } else if (pattern.charAt(indexPattern) == '*') {
                    indexPattern++;
                    indexClass++;
                } else if (Character.isLowerCase(pattern.charAt(indexPattern))){
                    break;
                } else {
                    indexClass++;
                }
            }
        }
        if (!isBlankOnEndOfPattern) {
            return indexPattern == pattern.length();
        } else {
            return indexPattern == pattern.length() && indexClass == className.length();
        }
    }
}
