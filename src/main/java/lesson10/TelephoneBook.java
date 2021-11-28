package lesson10;

import java.util.HashSet;
import java.util.Set;

public class TelephoneBook {

    private Set<Abonent> telephone_book = new HashSet<>();

    @Override
    public String toString() {
        String spisok = "{ ";
        for(Abonent elem : telephone_book) {
            spisok += elem.toString()+", ";
        }
        spisok += "}";
        return spisok;
    }

    public void add(String telephoneNumber, String lastName) {
        telephone_book.add(new Abonent(telephoneNumber,lastName));
    }

    public String get(String lastName) {
        String telephoneNumbers = "";
        for (Abonent elem : telephone_book) {
            if(elem.getLastName().equals(lastName)) {
                telephoneNumbers += elem.getTelephone() + " ";
            }
        }
        return telephoneNumbers;
    }

}
