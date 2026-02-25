/*
 * Mitchell Ramirez
 * CS-320
 */
package ContactService;
import java.util.List;
import java.util.ArrayList;

public class ContactService {
	int currentIDNum = 0;

	public final List<Contact> contactList = new ArrayList<Contact>();

	public void addContact(String firstName, String lastName, String phoneNumber, String address) {
		String stringID = Integer.toString(currentIDNum);
		Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
		contactList.add(newContact);
		//increasing the ID number
		++currentIDNum;
	}
	public void deleteContact(String ID) {
		contactList.removeIf(contact -> String.valueOf(contact.getContactID()).equals(ID));
			}

	public void editFirstName(String contactID, String firstName) {
		for(Contact iter : contactList) {
			if(String.valueOf(iter.getContactID()).equals(contactID)) {
                iter.setFirstName(firstName);
                return;
			}
		}
	}

	public void editLastName(String contactID, String lastName) {
        for (Contact iter : contactList) {
            if (String.valueOf(iter.getContactID()).equals(contactID)) {
                iter.setLastName(lastName);
                return;
			}
		}
	}
	public void editNumber(String contactID, String phoneNumber) {
        for (Contact iter : contactList) {
            if (String.valueOf(iter.getContactID()).equals(contactID)) {
                iter.setPhoneNumber(phoneNumber);
                return;
			}
		}
	}
	public void editAddress(String contactID, String address) {
        for (Contact iter : contactList) {
            if (String.valueOf(iter.getContactID()).equals(contactID)) {
                iter.setAddress(address);
                return;
			}
		}
	}
}
