/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.Contact;
import java.util.Map;

/**
 *
 * @author cna canal walk
 */
public class ContactFactory {

    public static Contact getContact(Map<String, String> values) {
        Contact contact = new Contact();
        contact.setEmailAddress(values.get("emailAddress"));
        contact.setCellPhoneNumber(values.get("cellPhoneNumber"));
        contact.setHomeNumber(values.get("homeNumber"));
        contact.setOfficeNumber(values.get("officeNumber"));
        return contact;
    }
}
