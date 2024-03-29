package com.commerce.express.app.factory;

import com.commerce.express.domain.Contact;

/**
 *
 * @author cna canal walk
 */
public class ContactFactory {

    private ContactFactory() {
    }

    public static Contact getContact(String emailAddress, String cellPhoneNumber, String homeNumber, String officeNumber) {
        Contact contact = new Contact();
        contact.setEmailAddress(emailAddress);
        contact.setCellPhoneNumber(cellPhoneNumber);
        contact.setHomeNumber(homeNumber);
        contact.setOfficeNumber(officeNumber);
        return contact;
    }
}
