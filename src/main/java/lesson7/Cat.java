package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Bowl bowl) {
       if (bowl.decreaseFood(appetite)) {
           satiety = true;
           System.out.printf("%s поел\n", name);
       }
          else System.out.printf("%s не смог поесть\n", name);
    }

    public void infoCat () {
        System.out.printf("Кот - %s, аппетит - %d\n",name,appetite);
    }
    public void infoCatSatiety () {
        if (satiety) {
            System.out.printf("Кот - %s, сыт\n", name);
        } else {
            System.out.printf("Кот - %s, голоден\n", name);
        }
    }

}
