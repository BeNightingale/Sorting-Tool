package sorting;

import java.util.List;
import java.util.Scanner;

public class Util {

    private Util() {
        // sth
    }

    protected static void evaluateInput(Scanner scanner, String inputType) {
        Algorithms algorithms = new Algorithms();
        String result = switch (inputType) {
            case "long-natural" -> {
                List<Long> numbersList = algorithms.readLongs(scanner);
                yield algorithms.sortLongNaturallyFunction.apply(numbersList);
            }
            case "long-byCount" -> {
                List<Long> numbersList = algorithms.readLongs(scanner);
                yield algorithms.sortLongByCountFunction.apply(numbersList);
            }
            case "line-natural" -> {
                List<String> linesList = algorithms.readLines(scanner);
                yield algorithms.sortLinesNaturallyFunction.apply(linesList);
            }
            case "line-byCount" -> {
                List<String> linesList = algorithms.readLines(scanner);
                yield algorithms.sortLinesByCountFunction.apply(linesList);
            }
            case "word-natural" -> {
                List<String> wordsList = algorithms.readWords(scanner);
                yield algorithms.sortWordsNaturallyFunction.apply(wordsList);
            }
            case "word-byCount" -> {
                List<String> wordsList = algorithms.readWords(scanner);
                yield algorithms.sortWordsByCountFunction.apply(wordsList);
            }
            default -> {
                System.out.println("error");
                yield "";
            }
        };
        System.out.println(result);
    }
}
