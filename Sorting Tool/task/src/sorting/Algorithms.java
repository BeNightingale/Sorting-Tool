package sorting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Algorithms {

    Function<List<Long>, String> longFunction = numbersList -> {
        numbersList.sort(Comparator.reverseOrder());
        long total = numbersList.size();
        long max = numbersList.get(0);
        long counter = numbersList.stream().filter(n -> n == max).count();
        long percentageCounterInTotal = Math.round(counter / (double) total * 100);
        return String.format("Total numbers: %s.%nThe greatest number: %s (%s time(s), %s%s).%n",
                total, max, counter, percentageCounterInTotal, "%");
    };

    Function<List<Long>, String> sortLongFunction = numbersList -> {
        numbersList.sort(Comparator.naturalOrder());
        long total = numbersList.size();
        String concatenatedList = numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return String.format("Total numbers: %s.%nSorted data: %s", total, concatenatedList);
    };

    Function<List<String>, String> lineFunction = linesList -> { // a co jeśli dwie różne linie mają tę samą największą długość????
        linesList.sort(Comparator.comparingInt(String::length).reversed());
        long total = linesList.size();
        String longestLine = linesList.get(0);
        long counter = linesList.stream().filter(l -> Objects.equals(l, longestLine)).count(); // porównanie co do wartości
        long percentageCounterInTotal = Math.round(counter / (double) total * 100);
        return String.format("Total lines: %s.%nThe longest line:%n%s%n(%s time(s), %s%s).%n",
                total, longestLine, counter, percentageCounterInTotal, "%");
    };

    Function<List<String>, String> wordFunction = wordsList -> { // a co jeśli dwie różne linie mają tę samą największą długość????
        wordsList.sort(Comparator.comparingInt(String::length).reversed());
        long total = wordsList.size();
        String longestWord = wordsList.get(0);
        long counter = wordsList.stream().filter(l -> Objects.equals(l, longestWord)).count(); // porównanie co do wartości
        long percentageCounterInTotal = Math.round(counter / (double) total * 100);
        return String.format("Total words: %s.%nThe longest word: %s (%s time(s), %s%s).%n",
                total, longestWord, counter, percentageCounterInTotal, "%");
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
}
