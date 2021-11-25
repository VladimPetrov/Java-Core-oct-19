package lesson10;

import java.util.*;

public class HomeWork {
    
    static int max_Length_Array = 30;
    static String[] words = {"apple", "orange", "lemon", "banana",  "cherry","kiwi", "mango"};
    static List<String> array_of_words = new ArrayList<>();
    static Map<String, Integer> array_of_unique_words = new HashMap<>();

    public static void main (String[] args) {

        task1();
        task2();

    }

    private static void task2() {
        String[][] arrayAbonents = {{"Petrov", "+79993332211"}, {"Ivanov", "+79990002211"}, {"Smirnov", "+79997772211"}, {"Sidorov",  "+79996662211"},
                {"Smirnov", "+79994442211"}, {"Smirnov", "+79995552211"}, {"Smirnov", "+79998883211"}};
        TelephoneDirectory telephoneBook = new TelephoneDirectory();

        for(int i = 0; i < arrayAbonents.length; i++) {
            telephoneBook.add(arrayAbonents[i][1], arrayAbonents[i][0]);
        }

        System.out.println(telephoneBook.get("Petrov"));
        System.out.println(telephoneBook.get("Smirnov"));
        System.out.println(telephoneBook.get_array("Smirnov"));

    }

    private static void task1() {

        int max_Length_Array = 30;
        String[] words = {"apple", "orange", "lemon", "banana",  "cherry","kiwi", "mango"};
        List<String> array_of_words = new ArrayList<>();
        Map<String, Integer> array_of_unique_words = new HashMap<>();
        Random rand = new Random();

        for (int i = 0; i < max_Length_Array; i++) {
            array_of_words.add(words[rand.nextInt(words.length)]);
        }

        System.out.println(array_of_words);

        for (String elem: array_of_words) {
            if(array_of_unique_words.containsKey(elem)) {
                array_of_unique_words.put(elem,array_of_unique_words.get(elem)+1);
            } else {
                array_of_unique_words.put(elem,1);
            }
        }

        System.out.println("Повторения слов:");

        for (Map.Entry entry : array_of_unique_words.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"=" + entry.getValue());
        }
    }


    
}
