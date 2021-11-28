package lesson10;

import java.util.Objects;

public class Abonent {
    private String telephone;
    private String lastName;

    public Abonent(String telephone, String lastName) {
        this.telephone = telephone;
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return   lastName + "=" + telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return Objects.equals(telephone, abonent.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephone);
    }
}
