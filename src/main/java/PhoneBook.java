import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    Map<String, List<Contact>> phoneBook = new HashMap<>();


    public static Contact contactCreate(String name, String phone) {
        return new Contact(name, phone);
    }


    public boolean addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addContact(Contact contact, String... groups) {
        for (String targetGroup : groups) {
            if (phoneBook.containsKey(targetGroup)) {
                phoneBook.get(targetGroup).add(contact);
            } else {
                addGroup(targetGroup);
                phoneBook.get(targetGroup).add(contact);
            }
        }
        return true;
    }

    public List<Contact> searchByGroup(String groupName) {
        return new ArrayList<>(phoneBook.get(groupName));
    }

    public Contact searchByPhone(String phone) {
        for (List <Contact> group : phoneBook.values()) {
            for (Contact contact : group) {
                if (contact.getPhoneNumber().equals(phone)) {
                    return contact;
                }
            }
        } return null;
    }


}
