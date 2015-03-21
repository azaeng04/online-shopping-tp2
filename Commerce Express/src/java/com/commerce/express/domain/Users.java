package com.commerce.express.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ronald
 */
public interface Users extends Serializable{

    public List<Address> getAddresses();

    public void setAddresses(List<Address> addresses);

    public Contact getContact();

    public void setContact(Contact contact);

    public void setFirstName(String firstName);

    public String getFirstName();

    public void setLastName(String lastName);

    public String getLastName();

    public void setMiddleName(String middleName);

    public String getMiddleName();

    public void setDateOfBirth(String dateOfBirth);

    public String getDateOfBirth();

    public void setGender(String gender);

    public String getGender();

    String getUserID();

    void setUserID(String userID);
    
    AccessDetails getAccessDetails();

    void setAccessDetails(AccessDetails user);
}
