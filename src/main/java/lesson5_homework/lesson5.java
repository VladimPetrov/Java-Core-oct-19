package lesson5_homework;

public class lesson5 {
    public static void main(String[] args) {
        Worker[] persArray = new Worker[5];
        persArray[0] = new Worker("Ivanov Ivan", "Engineer", "ivanov.i@mailbox.com",
                "+79998887766",30000,41);
        persArray[1] = new Worker("Smirnov Egor", "Engineer", "smirnov.e@mailbox.com",
                "+79998887655",30000,30);
        persArray[2] = new Worker("Smirnov Ivan", "Engineer", "smirnov.i@mailbox.com",
                "+79998887544",30000,42);
        persArray[3] = new Worker("Sidorov Ivan", "Engineer", "Sidorov.i@mailbox.com",
                "+79998887433",30000,33);
        persArray[4] = new Worker("Petrov Ivan", "Engineer", "petrov.i@mailbox.com",
                "+79998887322",30000,39);
        /*
        for(int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) persArray[i].printInfoWorker();
        }
        */
        for(Worker person : persArray) {
            if (person.getAge() > 40) person.printInfoWorker();
        }
    }
}
