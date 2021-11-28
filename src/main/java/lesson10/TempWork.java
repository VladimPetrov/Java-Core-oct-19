package lesson10;

public class TempWork {
    public static void main(String[] args) {
        String[][] arrayAbonents = {{"Petrov", "+79993332211"}, {"Ivanov", "+79990002211"}, {"Smirnov", "+79997772211"}, {"Sidorov",  "+79996662211"},
                {"Smirnov", "+79994442211"}, {"Smirnov", "+79995552211"}, {"Smirnov", "+79998883211"}};
        TelephoneBook telephoneBook = new TelephoneBook();

        for(int i = 0; i < arrayAbonents.length; i++) {
            telephoneBook.add(arrayAbonents[i][1], arrayAbonents[i][0]);
        }
        System.out.println(telephoneBook.toString());
        telephoneBook.add("+79993332211", "Kruglov");
        System.out.println(telephoneBook.toString());

        System.out.println(telephoneBook.get("Petrov"));
        System.out.println(telephoneBook.get("Smirnov"));
        //System.out.println(telephoneBook.get_array("Smirnov"));
    }
}
