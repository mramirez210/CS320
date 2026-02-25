/*
 * Mitchell Ramirez
 * CS-320
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ContactService.Contact;

class ContactTest {

    // "GOod" testing for the junit
    private String validID = "1234567890";
    private String validPhone = "1234567890"; // This phone number needs to be at 10 numbers

    @DisplayName("Testing the good constructor")
    @Test public void testGoodConstructor() {
        Contact testContact = new Contact(validID, "Ned", "Flanders", validPhone, "744 Evergreen Terrace");
        
        assertEquals(validID, testContact.getContactID());
        assertEquals("Ned", testContact.getFirstName());
        assertEquals(validPhone, testContact.getPhoneNumber());
    }

    @DisplayName("Testing an invalid length setFirstName")
    @Test public void testLongSetFirst() {
        Contact testContact = new Contact(validID, "Ned", "Flanders", validPhone, "744 Evergreen Terrace");
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setFirstName("ThisisWaytolongforaname"); // a name tha tis way too long
        });
    }

    @DisplayName("test getID")
    @Test public void testGetID() {
        Contact testContact = new Contact("3", "Ned", "Flanders", validPhone, "744 Evergreen Terrace");
        assertEquals("3", testContact.getContactID());
    }

    @DisplayName("Testing a too long getID")
    @Test public void testLongGetID() {
        // Phone number must be longer than 10 characters to trigger
        String longID = "123456789011111"; 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(longID, "Ned", "Flanders", validPhone, "744 Evergreen Terrace");
        });
    }

    @DisplayName("Testing valid length setPhoneNumber")
    @Test public void testGoodPhone() {
        Contact testContact = new Contact(validID, "Ned", "Flanders", validPhone, "744 Evergreen Terrace");
        testContact.setPhoneNumber("3038675309"); // Phone number is exactly 10 digits
        assertEquals("3038675309", testContact.getPhoneNumber());
    }

    @DisplayName("Testing an invalid length setPhoneNumber")
    @Test public void testLongLengthPhone() {
        Contact testContact = new Contact(validID, "Ned", "Flanders", validPhone, "744 Evergreen Terrace");
        
        // When the test is too short
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNumber("123");
        });
        
        // when the test Test too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNumber("123456789012345");
        });
    }
}