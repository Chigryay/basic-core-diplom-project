package service;

import data.Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final List<Contact> contactList;
    private final BufferedReader reader;

    protected AddressBook() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        contactList = new ArrayList<>();
    }

    protected void addContact() throws IOException {
        Contact contact = returnNewContact();

        if (contactList.contains(contact)) {
            System.out.println("Пользователь " + contact.getFullName() + " уже присутствует в списке" +
                    "контактов, он будет обновлён в соответствии с новыми данными.");

            int index = contactList.indexOf(contact);
            updateContact(contact, index);

            System.out.println("Контакт был обновлён");
        } else {
            System.out.println("Новый контакт добавлен");
            contactList.add(contact);
        }

    }

    protected void removeContact() throws IOException{
        System.out.println("Введите ID контакта: ");
        int index = Integer.parseInt(reader.readLine());
        if (index >= 0 && index < contactList.size()) {
            contactList.remove(index);
            System.out.println("Контакт с ID: " + index + " удален");
        } else {
            System.out.println("Пользователь с ID: " + index + " не найден");
        }
    }

    protected void printAddressBook() {
        if (contactList.isEmpty()) {
            System.out.println("Адресная книга пуста");
            return;
        }
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println("ID: " + i);
            System.out.println(contactList.get(i));
        }
    }

    private void updateContact(Contact contact, int index) {
        contactList.get(index).setPosition(contact.getPosition());
        contactList.get(index).setBirthday(contact.getBirthday());
        contactList.get(index).setPhoneNumber(contact.getPhoneNumber());
        contactList.get(index).setEmail(contact.getEmail());
    }

    private Contact returnNewContact() throws IOException {
        System.out.print("Введите Ф. И. О.: ");
        String fullName = reader.readLine();

        System.out.print("Введите должность: ");
        String position = reader.readLine();

        System.out.print("Введите дату рождения: ");
        String birthday = reader.readLine();

        System.out.print("Введите номер телефона: ");
        String phoneNumber = reader.readLine();

        System.out.print("Введите адресную почту: ");
        String email = reader.readLine();

        return new Contact(fullName, position, birthday, phoneNumber, email);
    }
}
