package sorting;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        Util.validateInput(args);
        String sortingType = Util.determineSortingType(args);
        String dataType = Util.determineDataType(args);
        Map<String, String> readingParams = Util.determineReadingInputType(args);
        String readingInputType = readingParams.get("readingInputType");
        String inputFileName = readingParams.get("inputFileName");
        Map<String, String> writingParams = Util.determineOutputType(args);
        String writingOutputType = writingParams.get("writingOutputType");
        String outputFileName = writingParams.get("outputFileName");
        String result = "";
        try {
            result = Util.evaluateInput(scanner, dataType, readingInputType, sortingType, inputFileName);
        } catch (FileNotFoundException ex) {
            System.out.printf("An inputFile with a name %s doesn't exist.%n", inputFileName);
        }
        Util.showResult(result, writingOutputType, outputFileName);
    }
}