package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sortingType = "natural";
        String dataType = "line";
        if (Arrays.binarySearch(args, "byCount") > 0) {
            sortingType = "byCount";
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