package guess_the_number;

import java.util.Random;
import java.util.Scanner;

public class guess_number {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randomNum = rand.nextInt(10);
        int playerNumber;
        System.out.println("Угадайте загаданное число!!!");
        do {
            for (int i = 1; i < 4; i++) {
                System.out.println("Попытка №" + i);
                System.out.println("Введите число:");
                playerNumber = scanner.nextInt();
                if (playerNumber == randomNum) {
                    System.out.println("Вы угадали число!");
                    break;
                }
                System.out.println("Вы не угадали число.");
                if (playerNumber > randomNum) {
                    System.out.println("Загаданное число меньше "+playerNumber);
                }
                if (playerNumber < randomNum) {
                    System.out.println("Загаданное число больше "+playerNumber);
                }
            }
            System.out.print("Повторить игру еще раз? 1 – да / 0 – нет:");
        } while (1 == scanner.nextInt());
    }
}
