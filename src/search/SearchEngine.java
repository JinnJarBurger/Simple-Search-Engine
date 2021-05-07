package search;

import java.util.*;
import java.util.stream.IntStream;

public class SearchEngine {

    private final ArrayList<String> database;
    private final Map<String, TreeSet<Integer>> position;

    SearchEngine(ArrayList<String> database) {
        this.database = database;
        position = new HashMap<>();
    }

    public void run() {
        invertedIndex();
    }

    private void invertedIndex() {
        // to load the keys
        database.forEach(line -> {
            String[] words = line.split("\\s+");
            Arrays.stream(words).forEach(word -> position.put(word.toLowerCase(), new TreeSet<>(Set.of())));
        });
        // to load the values
        IntStream.range(0, database.size()).forEach(index -> position.forEach((word, indices) -> {
            if (database.get(index).toLowerCase().contains(word)) {
                position.get(word).add(index);
            }
        }));
        menu();
    }

    private void searchAll(List<String> matches, String line) {
        Set<Integer> indicesSet = new TreeSet<>();
        List<String> words = Arrays.asList(line.toLowerCase().split("\\s+"));
        words.forEach(word -> indicesSet.addAll(position.getOrDefault(word,
                new TreeSet<>(Collections.emptySet()))));
        indicesSet.forEach(index -> {
            if (Arrays.asList(database.get(index).toLowerCase().split("\\s+")).containsAll(words)) {
                matches.add(database.get(index));
            }
        });
    }

    private void searchAny(List<String> matches, String line) {
        Set<Integer> indicesSet = new TreeSet<>();
        List<String> words = Arrays.asList(line.toLowerCase().split("\\s+"));
        words.forEach(word -> indicesSet.addAll(position.getOrDefault(word,
                new TreeSet<>(Collections.emptySet()))));
        indicesSet.forEach(index -> matches.add(database.get(index)));
    }

    private void searchNone(List<String> matches, String line) {
        Set<Integer> indicesSet = new TreeSet<>();
        List<String> words = Arrays.asList(line.toLowerCase().split("\\s+"));
        words.forEach(word -> indicesSet.addAll(position.getOrDefault(word,
                new TreeSet<>(Collections.emptySet()))));
        IntStream.range(0, database.size()).forEach(i -> {
            if (!indicesSet.contains(i)) {
                matches.add(database.get(i));
            }
        });
    }

    private void findPerson() {
        List<String> matches = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        String strategy = sc.nextLine().toUpperCase();
        System.out.println("\nEnter a name or email to search all suitable people.");
        switch (strategy) {
            case "ALL" -> searchAll(matches, sc.nextLine());
            case "ANY" -> searchAny(matches, sc.nextLine());
            case "NONE" -> searchNone(matches, sc.nextLine());
        }
        if (!(matches.size() == 0)) {
            System.out.printf("%n%d persons found:%n", matches.size());
            matches.forEach(System.out::println);
        } else {
            System.out.println("No matching people found.");
        }
    }

    private void printDatabase() {
        System.out.printf("%n=== List of people ===%n");
        database.forEach(System.out::println);
    }
    
    private void menu() {
        Scanner sc = new Scanner(System.in);
        int option;
        while (true) {
            System.out.printf("%n=== Menu ===%n");
            System.out.printf("1. Find a person%n2. Print all people%n0. Exit%n");
            option = sc.nextInt();
            if (option == 1) {
                findPerson();
            } else if (option == 2) {
                printDatabase();
            } else if (option == 0) {
                System.out.printf("%nBye!%n");
                break;
            } else {
                System.out.printf("%nIncorrect option! Try again.%n");
            }
        }
    }
}
