package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfSortInputs = Arrays.stream(args)
                .filter("-sortIntegers"::equals).count();
        String inputType;
        if (numberOfSortInputs != 0) {
            inputType = "sortNumbers";
        } else if (args[0].isEmpty()) {
            inputType = "word";
        } else {
            inputType = args[1];
        }
        Util.evaluateInput(scanner, inputType);
    }
}