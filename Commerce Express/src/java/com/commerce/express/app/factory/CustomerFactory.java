/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Address;
import com.commerce.express.domain.Contact;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.AccessDetails;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Owner
 */
public class CustomerFactory {
    public static class Builder {

        private String customerNumber = "CUS";
        private String firstName;
        private String lastName;
        private String middleName;
        private String gender;
        private Date dateOfBirth;
        private Contact contact;
        private AccessDetails accessDetails;
        private List<Address> addresses;

        public Builder(String customerNumber, AccessDetails accessDetails1) {
            this.customerNumber += customerNumber;
            this.accessDetails = accessDetails1;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Customer buildCustomer() {
            return buildCustomer(this);
        }

        private Customer buildCustomer(Builder object) {
            Customer customer = new Customer();
            customer.setUserID(object.customerNumber);
            customer.setAccessDetails(object.accessDetails);
            customer.setAddresses(object.addresses);
            customer.setDateOfBirth(object.dateOfBirth);
            customer.setFirstName(object.firstName);
            customer.setGender(object.gender);
            customer.setLastName(object.lastName);
            customer.setMiddleName(object.middleName);
            customer.setContact(object.contact);
            return customer;
        }
    }
}
