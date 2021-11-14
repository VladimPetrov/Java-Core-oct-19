package lesson7;

import java.util.Random;
import java.util.Scanner;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            System.out.printf("Еда уменьшилась на %d осталось %d\n", amount, foodAmount);
            return true;
        } else return false;

    }

    public void putFood(int amount) {
        foodAmount += amount;
        System.out.printf("Еда увеличилась на %d стало %d\n", amount, foodAmount);
    }

    public void putFoodRandom (int border) {
        Random rand = new Random();
        int amount = rand.nextInt(border) + 1;
        foodAmount += amount;
        System.out.printf("Еда увеличилась на %d стало %d\n", amount, foodAmount);
    }

    public void putFoodCustom () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Какое колличество еды добавить в тарелку:");
        int amount = scanner.nextInt();
        foodAmount += amount;
        System.out.printf("Еда увеличилась на %d стало %d\n", amount, foodAmount);
    }
}
