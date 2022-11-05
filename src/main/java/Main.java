import java.util.List;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addGroup("Семья");
        phoneBook.addGroup("Работа");

        phoneBook.addContact(phoneBook.contactCreate("Василий", "89277456810"), "Друзья");
        phoneBook.addContact(phoneBook.contactCreate("Ира", "89376150978"), "Семья");
        phoneBook.addContact(phoneBook.contactCreate("Иван", "83376459863"), "Друзья");
        phoneBook.addContact(phoneBook.contactCreate("Лена", "89396152890"), "Работа");
        phoneBook.addContact(phoneBook.contactCreate("Отец", "8365217591"), "Семья");
        phoneBook.addContact(phoneBook.contactCreate("Начальник", "83692584592"), "Работа",
                "Друзья");

        System.out.println("По номеру 83692584592 найден следующий контакт: " + phoneBook.searchByPhone("83692584592"));
        System.out.println();

        List<Contact> foundGroup = phoneBook.searchByGroup("Друзья");
        System.out.println("Друзья: ");
        for (Contact contact : foundGroup) {
            System.out.println(contact);
        }







    }
}
