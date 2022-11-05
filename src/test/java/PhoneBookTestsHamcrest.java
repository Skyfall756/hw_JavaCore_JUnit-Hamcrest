import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneBookTestsHamcrest {
    PhoneBook phoneBook;
    Contact testContact = new Contact("Ильдар", "82639586413");
    String testGroupName = "Друзья";


    @BeforeEach
    public void newPhoneBook() {
        phoneBook = new PhoneBook();
    }

    @AfterEach
    public void closePhoneBook() {
        phoneBook = null;
    }


    @Test
    public void testAddGroup() {
        //добавление группы
        MatcherAssert.assertThat(phoneBook.addGroup(testGroupName), equalTo(true));

        //добавление группы с уже существующим названием
        MatcherAssert.assertThat(phoneBook.addGroup(testGroupName), equalTo(false));

        MatcherAssert.assertThat(phoneBook.searchByGroup(testGroupName), hasSize(0));


    }

    @Test
    public void testAddContact() {

        MatcherAssert.assertThat(phoneBook.addContact(testContact, testGroupName), equalTo(true));
        MatcherAssert.assertThat(phoneBook.addContact(PhoneBook.contactCreate("Иван", "83561500279")),
                equalTo(true));


        MatcherAssert.assertThat(phoneBook.searchByPhone("82639586413"), equalTo(testContact));
        MatcherAssert.assertThat(phoneBook.searchByGroup(testGroupName), hasSize(1));
        MatcherAssert.assertThat(phoneBook.searchByGroup(testGroupName), hasItem(testContact));


    }

    @Test
    public void testSearchByPhone() {
        phoneBook.addContact(testContact, testGroupName);
        MatcherAssert.assertThat(phoneBook.searchByPhone("82639586413"), equalTo(testContact));

    }

    @Test
    public void testSearchByGroup() {
        phoneBook.addContact(testContact, testGroupName);
        List<Contact> foundGroup = phoneBook.searchByGroup(testGroupName);
        MatcherAssert.assertThat(foundGroup, equalTo(Arrays.asList(testContact)));
        MatcherAssert.assertThat(foundGroup, hasSize(1));
        MatcherAssert.assertThat(foundGroup, hasItem(testContact));
    }
}
