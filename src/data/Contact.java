package data;

import java.util.Objects;

public class Contact {

    private String fullName;
    private String position;
    private String birthday;
    private String phoneNumber;
    private String email;

    public Contact(String fullName, String position, String birthday, String phoneNumber, String email) {
        this.fullName = fullName;
        this.position = position;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Contact contact = (Contact) object;
        return Objects.equals(contact.getFullName().toUpperCase(), fullName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fullName) * 31 / 10;
    }

    @Override
    public String toString() {
        return  "Ф. И. О.: " + fullName + '\n' +
                "Должность: " + position + '\n' +
                "Дата рождения: " + birthday + '\n' +
                "Номер телефона: " + phoneNumber + '\n' +
                "Адрес электронной почты: " + email;
    }
}
