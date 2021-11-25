package lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private static Map<String, String> array_of_subscriber = new HashMap<>();

    public TelephoneDirectory() {

    }

    public void add(String telephoneNumber,String lastName){
        array_of_subscriber.put(telephoneNumber, lastName);
    }

    public String get(String lastName) {
        String telephoneNumbers = "";
        for (Map.Entry entry : array_of_subscriber.entrySet()) {
            if (lastName.equals(entry.getValue())) {
                telephoneNumbers += entry.getKey()+" ";
            }
        }
        return telephoneNumbers;
    }

    public ArrayList get_array(String lastName) {
        List<String> telephoneNumbers = new ArrayList<>();
        for (Map.Entry entry : array_of_subscriber.entrySet()) {
            if (lastName.equals(entry.getValue())) {
                telephoneNumbers.add(entry.getKey().toString());
            }
        }
        return (ArrayList) telephoneNumbers;
    }

}
