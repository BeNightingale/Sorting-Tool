package sorting;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //typy sortowania
    private static final String BY_COUNT = "byCount";
    private static final String NATURAL = "natural";

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sortingType = NATURAL;
        String dataType = "line";
        Arrays.sort(args);
        if (Arrays.binarySearch(args, "-sortingType") >= 1
                && Arrays.binarySearch(args, NATURAL) == 0
                && Arrays.binarySearch(args, BY_COUNT) == 0) {
            System.out.println("No sorting type defined!");
            throw new ArgumentException("No sorting type defined!");
        }
        if (Arrays.binarySearch(args, "-dataType") >= 1
                && Arrays.binarySearch(args, "line") == 0
                && Arrays.binarySearch(args, "word") == 0
                && Arrays.binarySearch(args, "long") == 0) {
            System.out.println("No data type defined!");
            throw new ArgumentException("No data type defined!");
        }
        for (String elem : args) {
            if (elem.startsWith("-") && !"-sortingType".equals(elem) && !"-dataType".equals(elem)) {
                String message = String.format("\"-%s\" is not a valid parameter. It will be skipped.%n", elem);
                System.out.printf(message);
            }
        }
        if (Arrays.binarySearch(args, BY_COUNT) > 0) {
            sortingType = BY_COUNT;
        }
        if (Arrays.binarySearch(args, "long") > 0) {
            dataType = "long";
        } else if (Arrays.binarySearch(args, "word") > 0) {
            dataType = "word";
        }
        String dataTypeAndSortType = dataType + "-" + sortingType;
        Util.evaluateInput(scanner, dataTypeAndSortType);
    }
}