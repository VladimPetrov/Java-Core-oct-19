package lesson5_homework;

public class Worker {
    private String fio;
    private String position;
    private String email;
    private String telephone;
    private int pay;
    private int age;

    public Worker(String fio, String position, String email, String telephone, int pay, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.pay = pay;
        this.age = age;
    }

    public void printInfoWorker() {
        System.out.println("---------------------------------------------");
        System.out.println(getFio());
        System.out.printf("Возраст: %d\n",getAge());
        System.out.printf("Должность: %s\n", getPosition());
        System.out.printf("email: %s    телефон: %s\n", getEmail(), getTelephone());
        System.out.printf("Зарплата: %d\n",getPay());
        System.out.println("---------------------------------------------");
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getPay() {
        return pay;
    }

    public int getAge() {
        return age;
    }
}
