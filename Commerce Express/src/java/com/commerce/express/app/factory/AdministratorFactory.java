/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.AccessDetails;
import com.commerce.express.domain.Address;
import com.commerce.express.domain.Contact;
import com.commerce.express.domain.Administrator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Owner
 */
public class AdministratorFactory {

    public static class Builder {

        private String administratorNumber = "ADM_";
        private String firstName;
        private String lastName;
        private String middleName;
        private String gender;
        private String dateOfBirth;
        private Contact contact;
        private AccessDetails accessDetails;
        private List<Address> addresses;

        public Builder(String administratorNumber, AccessDetails accessDetails1) {
            this.administratorNumber += administratorNumber;
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

        public Builder setDateOfBirth(String dateOfBirth) {
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

        public Administrator buildAdministrator() {
            return buildAdministrator(this);
        }

        private Administrator buildAdministrator(Builder object) {
            Administrator administrator = new Administrator();
            administrator.setUserID(object.administratorNumber);
            administrator.setAccessDetails(object.accessDetails);
            administrator.setAddresses(object.addresses);
            administrator.setDateOfBirth(object.dateOfBirth);
            administrator.setFirstName(object.firstName);
            administrator.setGender(object.gender);
            administrator.setLastName(object.lastName);
            administrator.setMiddleName(object.middleName);
            administrator.setContact(object.contact);
            return administrator;
        }
    }
}
