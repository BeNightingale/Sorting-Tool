package sorting;

import java.io.FileNotFoundException;
import java.util.*;

import static sorting.CommandArguments.*;

public class Util {

    //sorting types
    private static final String BY_COUNT = "byCount";
    private static final String NATURAL = "natural";
    // reading input types
    private static final String MANUALLY = "manually";
    private static final String FROM_FILE = "fromFile";

    private Util() {
        // sth
    }

    protected static String evaluateInput(Scanner scanner, String dataType, String readingType, String sortingType, String inputFileName) throws FileNotFoundException {
        Algorithms algorithms = new Algorithms();
        return switch (dataType) {
            case "long" -> {
                List<Long> numbersList = switch (readingType) {
                    case MANUALLY -> algorithms.readLongs(scanner);
                    case FROM_FILE -> algorithms.readFileByLong(inputFileName);
                    default -> Collections.emptyList();
                };
                yield switch (sortingType) {
                    case NATURAL -> algorithms.sortLongNaturallyFunction.apply(numbersList);
                    case BY_COUNT -> algorithms.sortLongByCountFunction.apply(numbersList);
                    default -> "";
                };
            }
            case "line" -> {
                List<String> linesList = switch (readingType) {
                    case MANUALLY -> algorithms.readLines(scanner);
                    case FROM_FILE -> algorithms.readFileByLine(inputFileName);
                    default -> Collections.emptyList();
                };
                yield switch (sortingType) {
                    case NATURAL -> algorithms.sortLinesNaturallyFunction.apply(linesList);
                    case BY_COUNT -> algorithms.sortLinesByCountFunction.apply(linesList);
                    default -> "";
                };
            }
            case "word" -> {
                List<String> wordsList = switch (readingType) {
                    case MANUALLY -> algorithms.readWords(scanner);
                    case FROM_FILE -> algorithms.readFileByString(inputFileName);
                    default -> Collections.emptyList();
                };
                yield switch (sortingType) {
                    case NATURAL -> algorithms.sortWordsNaturallyFunction.apply(wordsList);
                    case BY_COUNT -> algorithms.sortWordsByCountFunction.apply(wordsList);
                    default -> "";
                };
            }
            default -> {
                System.out.println("error - unknown dataType");
                yield "";
            }
        };
    }

    public static void showResult(String content, String writingOutputType, String outputFileName) {
        Algorithms algorithms = new Algorithms();
        switch (writingOutputType) {
            case "toConsole" -> algorithms.writeStringToConsole.accept(content);
            case "toFile" -> algorithms.writeStringToFile.accept(content, outputFileName);
            default -> throw new ArgumentException("Wrong WritingOutputType.");
        }
    }

    public static void validateInput(String[] args) {
        String[] args2 = cloneAndSortArray(args);
        if (Arrays.binarySearch(args2, arguments.get(SORTING_TYPE)) >= 1
                && Arrays.binarySearch(args2, NATURAL) == 0
                && Arrays.binarySearch(args2, BY_COUNT) == 0) {
            System.out.println("No sorting type defined!");
            throw new ArgumentException("No sorting type defined!");
        }
        if (Arrays.binarySearch(args2, arguments.get(DATA_TYPE)) >= 1
                && Arrays.binarySearch(args2, "line") == 0
                && Arrays.binarySearch(args2, "word") == 0
                && Arrays.binarySearch(args2, "long") == 0) {
            System.out.println("No data type defined!");
            throw new ArgumentException("No data type defined!");
        }
        for (String elem : args2) {
            if (elem.startsWith("-") && !isStringMapsValue(elem)) {
                String message = String.format("\"-%s\" is not a valid parameter. It will be skipped.%n", elem);
                System.out.printf(message);
            }
        }
    }

    public static Map<String, String> determineReadingInputType(String[] args) { //return map key:readingInputType; value:fileInputName
        String readingInputType = MANUALLY;
        String inputFileName = "";
        String[] args2 = cloneAndSortArray(args);
        if (Arrays.binarySearch(args2, arguments.get(INPUT_FILE)) >= 1) {
            for (int i = 0; i < args.length; i++) {
                if (arguments.get(INPUT_FILE).equals(args[i]) && i != args.length - 1) {
                    readingInputType = FROM_FILE;
                    inputFileName = args[i + 1];
                    break;
                } else if (i == args.length - 1) {
                    System.out.println("No input fileName."); // typ wczytywania zostawiamy- ręcznie! Bo brak nazwy pliku, więc nie da się z pliku.
                }
            }
        }
        return Map.of("readingInputType", readingInputType, "inputFileName", inputFileName);
    }

    public static Map<String, String> determineOutputType(String[] args) {//return map key:writingOutputType; value:fileOutputName
        String writingOutputType = "toConsole";
        String outputFileName = "";
        String[] args2 = cloneAndSortArray(args);
        if (Arrays.binarySearch(args2, arguments.get(OUTPUT_FILE)) >= 1) {
            for (int i = 0; i < args.length; i++) {
                if (arguments.get(OUTPUT_FILE).equals(args[i]) && i != args.length - 1) {
                    writingOutputType = "toFile";
                    outputFileName = args[i + 1];
                    break;
                } else if (i == args.length - 1) {
                    System.out.println("No output fileName."); // typ wypisywania zostawiamy- do konsoli! Bo brak nazwy pliku, więc nie da się do pliku.
                }
            }
        }
        return Map.of("writingOutputType", writingOutputType, "outputFileName", outputFileName);
    }

    public static String determineSortingType(String[] args) {
        String sortingType = NATURAL;
        String[] args2 = cloneAndSortArray(args);
        if (Arrays.binarySearch(args2, BY_COUNT) > 0) {
            sortingType = BY_COUNT;
        }
        return sortingType;
    }

    public static String determineDataType(String[] args) {
        String dataType = "line";
        String[] args2 = cloneAndSortArray(args);
        if (Arrays.binarySearch(args2, "long") > 0) {
            dataType = "long";
        } else if (Arrays.binarySearch(args2, "word") > 0) {
            dataType = "word";
        }
        return dataType;
    }

    public static String[] cloneAndSortArray(String[] args) {
        String[] args2 = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            args2[i] = args[i];
        }
        Arrays.sort(args2);
        return args2;
    }
}
