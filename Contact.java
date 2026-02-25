/*Mitchell Ramirez
 * CS-320
 */
 
package ContactService;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	/*
	 * This will validate the contactID
	 * with @param being contactID and @return bool
	 */
	private final boolean validateID(String contactID) {
		if (contactID == null || contactID.length() > 10) {
			return false;
		} return true;
	}
	/*
	 * This will validate the last name
	 * the @param lastName and @return bool
	 */
	private final boolean validateLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			return false;
		} return true;
	}
	/*
	 * validating firstName
	 * @param firstName & @return bool
	 */
	private final boolean validatefirstName(String firstName) {
	    if (firstName == null || firstName.length() > 10) {
	        return false;
	    } return true;
	}
	/*
	 * Validating the phone number
	 * @param phoneNumber & @return bool
	 */
	private final boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() != 10) {
			return false;
		} return true;
	}
	/*
	 * Validating the address
	 * @param address & @return bool
	 */
	private final boolean validateAddress(String address) {
		if (address == null || address.length() > 30) {
			return false;
		} return true;
	}
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		if(!this.validateID(contactID)) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if(!this.validatefirstName(firstName)) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if(!this.validateLastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(!this.validateAddress(address)) {
			throw new IllegalArgumentException("Invalid address");
		}
		if(!this.validatePhoneNumber(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	} 
	public String getContactID() {
	    return contactID;
	}
	public String getFirstName() {
		return firstName;
	} 
	public void setFirstName(String firstName) {
		if(!this.validatefirstName(firstName)) {
			throw new IllegalArgumentException("Invalid First Name");
		} this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
		public void setLastName(String lastName) {
			if(!this.validateLastName(lastName)) {
				throw new IllegalArgumentException("Invalid last name");
		}this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	} 
	public void setPhoneNumber(String phoneNumber) {
	    if(!this.validatePhoneNumber(phoneNumber)) {
	        throw new IllegalArgumentException("Invalid phone number");
	    }
	    this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
	if(!this.validateAddress(address)) {
		throw new IllegalArgumentException("Invalid address");
		} this.address = address;
	}
}