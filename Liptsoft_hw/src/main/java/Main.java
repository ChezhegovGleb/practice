import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Invalid number of arguments, must be 2");
        }

        String fileName = args[0];
        Boolean isBlankOnEndOfPattern = args[1].charAt(args[1].length() - 1) == ' ';
        String pattern = (isBlankOnEndOfPattern) ? args[1].substring(0, args[1].length() - 1) : args[1];

        ArrayList<Pair<String, String>> fullNameAndSimpleNameClasses = readInputFile(fileName);

        fullNameAndSimpleNameClasses
                .stream()
                .filter(it -> Matcher.matches(it.value, pattern, isBlankOnEndOfPattern))
                .sorted(Comparator.comparing(a -> a.value))
                .map(it -> it.key)
                .forEach(System.out::println);
    }

    private static ArrayList<Pair<String, String>> readInputFile(String fileName) {
        ArrayList<Pair<String, String>> listClasses = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String fullClassName = reader.readLine();
            while (fullClassName != null) {
                String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
                listClasses.add(new Pair(fullClassName, simpleClassName));
                fullClassName = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listClasses;
    }
}
