package sorting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Algorithms {

    Function<List<Long>, String> sortLongNaturallyFunction = numbersList -> {
        numbersList.sort(Comparator.naturalOrder());
        long total = numbersList.size();
        String concatenatedList = numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return String.format("Total numbers: %s.%nSorted data: %s", total, concatenatedList);
    };

    Function<List<Long>, String> sortLongByCountFunction = numbersList -> {
        long total = numbersList.size();
        Map<Long, Integer> numOccurrences = new TreeMap<>();
        List<Long> distinctLongs = numbersList.stream().distinct().collect(Collectors.toList());
        distinctLongs.forEach(num -> numOccurrences.put(num, Collections.frequency(numbersList, num)));
        Set<Map.Entry<Long, Integer>> entries = numOccurrences.entrySet();
        Map<Long, Integer> sortedMap = entries
                .stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))//sortowanie grup, które mają tę samą liczbę wystąpień (czyli to samo value) według wartości, czyli wg klucza
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return String.format("Total numbers: %s.%n%s", total, formatOccurrencesMap(sortedMap, total));
    };

    Function<List<String>, String> sortLinesNaturallyFunction = linesList -> {
        linesList.sort(Comparator.naturalOrder());
        long total = linesList.size();
        return String.format("Total lines: %s%nSorted data:%n%s", total, formatLinesList(linesList)); // NIE MA KROPKI!!!
    };

    Function<List<String>, String> sortLinesByCountFunction = linesList -> {
        long total = linesList.size();
        Map<String, Integer> lineOccurrences = new TreeMap<>();
        List<String> distinctLines = linesList.stream().distinct().collect(Collectors.toList());
        distinctLines.forEach(line -> lineOccurrences.put(line, Collections.frequency(linesList, line)));
        Set<Map.Entry<String, Integer>> entries = lineOccurrences.entrySet();
        Map<String, Integer> sortedMap = entries.stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
        return String.format("Total lines: %s.%n%s", total, formatOccurrencesMap(sortedMap, total));
    };

    Function<List<String>, String> sortWordsNaturallyFunction = wordsList -> {
        wordsList.sort(Comparator.naturalOrder());// porównywanie wg znaków czy wartości liczb???
        long total = wordsList.size();
        return String.format("Total words: %s.%nSorted data: %s", total, formatWordsList(wordsList));
    };

    Function<List<String>, String> sortWordsByCountFunction = wordsList -> {
        long total = wordsList.size();
        Map<String, Integer> wordOccurrences = new TreeMap<>();
        List<String> distinctWords = wordsList.stream().distinct().collect(Collectors.toList());
        distinctWords.forEach(line -> wordOccurrences.put(line, Collections.frequency(wordsList, line)));
        Set<Map.Entry<String, Integer>> entries = wordOccurrences.entrySet();
        Map<String, Integer> sortedMap = entries.stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
        return String.format("Total words: %s.%n%s", total, formatOccurrencesMap(sortedMap, total));
    };

    public List<Long> readLongs(Scanner scanner) {
        List<Long> numbersList = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbersList.add(number);
        }
        return numbersList;
    }

    public List<String> readLines(Scanner scanner) {
        List<String> linesList = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            linesList.add(line);
        }
        return linesList;
    }

    public List<String> readWords(Scanner scanner) {
        List<String> wordsList = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            wordsList.add(word);
        }
        return wordsList;
    }

    private String formatLinesList(List<String> linesList) {
        return String.join("\n", linesList);
    }

    private String formatWordsList(List<String> list) {
        return String.join(" ", list);
    }

    private <K> String formatOccurrencesMap(Map<K, Integer> sortedMap, long totalNumbersCountInList) {
        return sortedMap.entrySet().stream()
                .map(entry -> String.format("%s: %s time(s), %s%s",
                        entry.getKey(), entry.getValue(), Math.round(entry.getValue() / (double) totalNumbersCountInList * 100), "%"))
                .collect(Collectors.joining("\n"));
    }
}
