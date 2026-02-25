/*
 * Mitchell Ramirez
 * CS-320
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ContactService.ContactService;

class ContactServiceTest {
    private ContactService service;

    // Using beforeeach to create a fresh testing after each
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @DisplayName("Test addContact")
    @Test
    void testAddContact() {
        String firstName = "Homer";
        String lastName = "Simpson";
        String phoneNumber = "1234567890";
        String address = "742 Evergreen Terrace";
        
        service.addContact(firstName, lastName, phoneNumber, address);
        
        // Veryifing that the stings are empty
        assertFalse(service.contactList.isEmpty());
        
        // Comparaing each to not be the same as "0"
        assertEquals("0", service.contactList.get(0).getContactID());
        assertEquals(firstName, service.contactList.get(0).getFirstName());
        assertEquals(lastName, service.contactList.get(0).getLastName());
        assertEquals(phoneNumber, service.contactList.get(0).getPhoneNumber());
        assertEquals(address, service.contactList.get(0).getAddress());
    }

    @DisplayName("Test deleteContact")
    @Test 
    void testDeleteContact() {
        // Adding multiple contacts
        service.addContact("Homer", "Simpson", "1234567890", "Address 1"); // ID 0
        service.addContact("Marge", "Simpson", "1234567890", "Address 2"); // ID 1
        service.addContact("Bart", "Simpson", "1234567890", "Address 3");  // ID 2
        
        assertEquals(3, service.contactList.size());
        
        // Calling the delete method
        service.deleteContact("1");
        
        // Verifying the sisze is 2
        assertEquals(2, service.contactList.size());
        
        // Looping through 1 to make sure that it works. 
        boolean found = false;
        for(int i = 0; i < service.contactList.size(); i++) {
            if(service.contactList.get(i).getContactID().equals("1")) {
                found = true;
            }
        } 
        assertFalse(found);
    }

    @DisplayName("Testing editing the phone number")
    @Test 
    void testEditPhoneNumber() {
        service.addContact("Homer", "Simpson", "1234567890", "Address");
        
        // Checking the initial state
        assertEquals("1234567890", service.contactList.get(0).getPhoneNumber());
        
        // Edit and verify
        service.editNumber("0", "9675820121"); // DIgits must be 10 digits long according to contact.java
        assertEquals("9675820121", service.contactList.get(0).getPhoneNumber());
    }

    @DisplayName("Testing editing the last name")
    @Test 
    void testEditLast() {
        service.addContact("Homer", "Simpson", "1234567890", "Address");
        
        service.editLastName("0", "TestName");
        assertEquals("TestName", service.contactList.get(0).getLastName());
    }

    @DisplayName("Testing editing the first name")
    @Test 
    void testEditFirst() {
        service.addContact("Homer", "Simpson", "1234567890", "Address");
        
        service.editFirstName("0", "TestFirst");
        assertEquals("TestFirst", service.contactList.get(0).getFirstName());
    }

    @DisplayName("Testing editing the Address")
    @Test 
    void testEditAddress() {
        service.addContact("Homer", "Simpson", "1234567890", "Address");
        
        service.editAddress("0", "New Test Address 123");
        assertEquals("New Test Address 123", service.contactList.get(0).getAddress());
    }
}