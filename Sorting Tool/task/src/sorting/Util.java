package sorting;

import java.util.List;
import java.util.Scanner;

public class Util {

    protected static void evaluateInput(Scanner scanner, String inputType) {
        Algorithms algorithms = new Algorithms();
        String result = switch (inputType) {
            case "long" -> {
                List<Long> numbersList = algorithms.readLongs(scanner);
                yield algorithms.longFunction.apply(numbersList);
            }
            case "line" -> {
                List<String> linesList = algorithms.readLines(scanner);
                yield algorithms.lineFunction.apply(linesList);
            }
            case "word" -> {
                List<String> wordsList = algorithms.readWords(scanner);
                yield algorithms.wordFunction.apply(wordsList);
            }
            case "sortNumbers" -> {
                List<Long> numbersList = algorithms.readLongs(scanner);
                yield algorithms.sortLongFunction.apply(numbersList);
            }
            default -> {
                System.out.println("error");
                yield "";
            }
        };
        System.out.println(result);
    }
}
