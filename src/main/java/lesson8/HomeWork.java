package lesson8;

import java.util.Random;

public class HomeWork {
    public static String[] customName = {"Джон", "Джек", "Боб", "Том", "Роб", "Сид"};
    public static Participant[] part = new Participant[8];
    public static Obstacle[] obstacle = new Obstacle[15];

    public static void main(String[] args) {
        newObstacle();
        newParticipant();

        int i = 1;
        for(Participant elem : part) {
            System.out.println("-----------------------");
            System.out.printf("Участник №%d -- %s\n",i,elem.toString());
            int j = 1;
            for(Obstacle obst : obstacle) {
                System.out.printf("Препятствие №%d -- %s\n",j,obst.toString());
                if (obst instanceof Wall) {
                    if (!elem.jump(((Wall) obst).getHieght())) {
                        System.out.println("участник выбывает");
                        break;
                    }
                }
                if (obst instanceof Track) {
                    if (!elem.run(((Track) obst).getLength())) {
                        System.out.println("участник выбывает");
                        break;
                    }
                }
                j++;
            }
            if(j == obstacle.length) {
                System.out.println("Участник преодолел все препятствия!!!!");
            }
            i++;
        }
    }

    public static void newParticipant() {
        Random rand = new Random();
        for(int i = 0; i < part.length; i++) {
            switch (rand.nextInt(3)) {
                case 0: {
                    part[i] = new Human(customName[rand.nextInt(6)], returnHeigth((float) 2.5), returnLegth(101));
                    break;
                }
                case 1: {
                    part[i] = new Robot(customName[rand.nextInt(6)], returnHeigth((float)1.5), returnLegth(80));
                    break;
                }
                case 2: {
                    part[i] = new Cat(customName[rand.nextInt(6)], returnHeigth((float)1.8), returnLegth(200));
                    break;
                }
            }
        }
    }

    public static void newObstacle() {
        Random rand = new Random();
        for(int i = 0; i < obstacle.length; i++) {
            switch (rand.nextInt(2)) {
                case 0: {
                    obstacle[i] = new Wall(returnHeigth((float) 2.2));
                    break;
                }
                case 1: {
                    obstacle[i] = new Track(returnLegth(101));
                    break;
                }
            }
        }
    }

    public static int returnLegth(int border) {
        Random rand = new Random();
        return rand.nextInt(border);
    }

    public static float returnHeigth(float border) {
        Random rand = new Random();
        double temp = rand.nextFloat()*border;
        return (float) (Math.ceil(temp*Math.pow(10,2))/Math.pow(10,2));
    }

}
