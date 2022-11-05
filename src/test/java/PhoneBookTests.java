import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class PhoneBookTests {
    PhoneBook phoneBook;
    Contact testContact = new Contact("Ильдар", "82639586413");
    String testGroupName = "Друзья";


    @BeforeEach
    public void newPhoneBook () {
        phoneBook = new PhoneBook();
    }

    @AfterEach
    public void closePhoneBook () {
        phoneBook = null;
    }


    @Test
    public void testAddGroup () {
        boolean expected = true;
        boolean result = phoneBook.addGroup(testGroupName);


        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testAddContact() {

        boolean result = phoneBook.addContact(testContact);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchByPhone() {
        phoneBook.addContact(testContact, testGroupName);

        Contact result = phoneBook.searchByPhone("82639586413");
        Assertions.assertEquals(testContact, result);

    }
    @Test
    public void testSearchByGroup() {
        phoneBook.addContact(testContact, testGroupName);
        List<Contact> result = phoneBook.searchByGroup(testGroupName);
        List<Contact> expected = Arrays.asList(testContact);

        Assertions.assertEquals(expected, result);


    }


}
