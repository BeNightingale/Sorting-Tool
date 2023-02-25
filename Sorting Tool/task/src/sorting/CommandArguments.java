package sorting;

import java.util.Map;

public enum CommandArguments {

    SORTING_TYPE, DATA_TYPE, INPUT_FILE, OUTPUT_FILE;
    static final Map<CommandArguments, String> arguments = Map.of(
            SORTING_TYPE, "-sortingType",
            DATA_TYPE, "-dataType",
            INPUT_FILE, "-inputFile",
            OUTPUT_FILE, "-outputFile");

    public static boolean isStringMapsValue(String elem) {
        if (elem == null || "".equals(elem)) {
            return false;
        }
        long elemCount = arguments.values().stream().filter(elem::equals).count();
        return elemCount > 0;
    }
}
