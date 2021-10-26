package guess_the_word;

import java.util.Random;
import java.util.Scanner;

public class guess_word {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                          "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                          "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                          "pumpkin", "potato"};
        int randomNum = rand.nextInt(25);
        String playerWord;
        System.out.println("Загаданное слово: "+words[randomNum]);
        System.out.println("Угадайте загаданное слово!!!");
        int i = 1;
        do {
            System.out.println("Попытка №" + i);
            System.out.println("Введите слово:");
            playerWord = scanner.next();
            if (playerWord.equals(words[randomNum])) {
               System.out.println("Вы выйграли");
               break;
            } else { System.out.println(findChar(playerWord,words[randomNum]));}
            i++;
        } while (true);

    }
    public static String findChar(String searchWord, String modelWord){
        String shadowStr = new String();
        int minLength;

        if (searchWord.length() <= modelWord.length()) {
            minLength = searchWord.length();
        } else { minLength = modelWord.length();}
        for (int i = 0; i < minLength; i++) {
            if (searchWord.charAt(i) == modelWord.charAt(i)) {
                shadowStr += searchWord.charAt(i);
            } else { shadowStr += '#';}
        }
        for (int i = minLength; i < 15; i++) {
            shadowStr += '#';
        }
        return shadowStr;
    }
}
