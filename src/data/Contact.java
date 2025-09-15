package data;

import java.util.Objects;

public class Contact {
    private String fullName;
    private String position;
    private String birthday;
    private String phoneNumber;
    private String email;

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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Contact contact = (Contact) object;
        return contact.getFullName().equals(fullName);
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
