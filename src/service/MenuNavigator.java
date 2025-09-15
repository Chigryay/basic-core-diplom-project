package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuNavigator {

    private final AddressBook addressBook;
    private final BufferedReader reader;

    public MenuNavigator() {
        addressBook = new AddressBook();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException {
        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(reader.readLine());
            action(choice);
        } while(choice != 4);
    }

    private void printMenu() {
        System.out.println("\nАдресная книга");

        String menu = "1 – новый контакт\n" +
                "2 – удаление существующего контакта\n" +
                "3 – вывод всех контактов\n" +
                "4 – завершение работы";

        System.out.println(menu);
        System.out.print("Введите нужную опцию и нажмите Enter [1..4]: ");
    }

    private void action(int action) throws IOException {
        switch (action) {
            case 1 -> addressBook.addContact();
            case 2 -> addressBook.removeContact();
            case 3 -> addressBook.printAddressBook();
            case 4 -> System.out.println("завершение работы");
            default -> System.out.println("Ошибка ввода");
        }
    }
}
