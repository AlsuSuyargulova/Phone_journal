import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class phone_number {

    // Метод, который добавляет номера в книгу
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    // Метод, который печатает список контактов
    public static void printBook(Map<String, ArrayList<Integer>> map){
        map.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue().size()))
                .forEach(entry -> {
                    String phones = entry.getValue().stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", "));
                    System.out.printf("%s: %s \n", entry.getKey(), phones);
                });
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Sidorov", 11111, bookPhone);
        addNumber("Ivanov", 22222, bookPhone);
        addNumber("Petrov", 333333, bookPhone);
        addNumber("Sidorov", 111222, bookPhone);
        addNumber("Ivanov", 222111, bookPhone);
        addNumber("Sidorov", 333211, bookPhone);
        printBook(bookPhone);
    }
}