import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MatcherTest {
    private List<String> checkAllClasses(List<String> listOfClasses, String pattern, Boolean isBlankOnEnd) {
        ArrayList<String> result = new ArrayList<>();
        for (var className : listOfClasses) {
            if (Matcher.matches(className, pattern, isBlankOnEnd)) {
                result.add(className);
            }
        }
        return result;
    }

    @Test
    public void simpleTest() {
        assertEquals(Matcher.matches("FooBarBaz", "fb*r", false), true);
    }

    @Test
    public void emptyTest() {
        assertEquals(Matcher.matches("", "", false), true);
    }

    @Test
    public void SimplePatternAndManyClassesTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "FooBar");
        String pattern = "FB";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of("FooBarBaz", "FooBar");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void SimplePatternAndManyClassesSecondTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "FooBar");
        String pattern = "FoBa";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of("FooBarBaz", "FooBar");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void SimplePatternAndManyClassesThirdTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "FooBar");
        String pattern = "FBar";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of("FooBarBaz", "FooBar");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void notMatchedClassTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "FooBar");
        String pattern = "BF";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of();

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void patternWithStarTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "BrBaz");
        String pattern = "B*rBaz";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of("FooBarBaz");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void patternInLowerCaseTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "BrBaz", "FooBar");
        String pattern = "fbb";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of("FooBarBaz");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void patternInLowerCaseNotFoundTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "BrBaz", "FooBar");
        String pattern = "fBb";
        Boolean isBlankOnEnd = false;
        List<String> expected = List.of();

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void patternWithBlankAtTheEndTest() {
        List<String> listOfClasses = List.of("FooBarBaz", "BrBaz", "FooBar");
        String pattern = "FBar";
        Boolean isBlankOnEnd = true;
        List<String> expected = List.of("FooBar");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void patternWithBlankAtTheEndSecondTest() {
        List<String> listOfClasses = List.of("FooBazBar", "BrBaz", "FooBar");
        String pattern = "Baz";
        Boolean isBlankOnEnd = true;
        List<String> expected = List.of("BrBaz");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }

    @Test
    public void patternWithBlankAtTheEndThirdTest() {
        List<String> listOfClasses = List.of("FooBazBar", "BrBaz", "FooBar");
        String pattern = "ar";
        Boolean isBlankOnEnd = true;
        List<String> expected = List.of("FooBazBar", "FooBar");

        List<String> result = checkAllClasses(listOfClasses, pattern, isBlankOnEnd);

        assertEquals(expected, result);
    }




}
