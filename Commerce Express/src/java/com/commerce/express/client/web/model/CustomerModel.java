/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.model;

import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Address;
import com.commerce.express.domain.Contact;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cna canal walk
 */
public class CustomerModel implements Serializable{

    private String userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private String gender;
    private AccessDetails accessDetails;
    private List<Address> addresses;
    private Contact contact;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AccessDetails getAccessDetails() {
        return accessDetails;
    }

    public void setAccessDetails(AccessDetails accessDetails) {
        this.accessDetails = accessDetails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
