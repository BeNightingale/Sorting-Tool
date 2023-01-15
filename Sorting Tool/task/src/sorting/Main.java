package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputType;
        if (args[0].isEmpty()) {
            inputType = "word";
        } else {
            inputType = args[1];
        }
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
            default -> {
                System.out.println("error");
                yield  "";
            }
        };
        System.out.println(result);
    }
}
