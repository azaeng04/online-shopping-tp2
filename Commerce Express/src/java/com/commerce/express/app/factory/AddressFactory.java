package com.commerce.express.app.factory;

import com.commerce.express.domain.Address;

/**
 *
 * @author cna canal walk
 */
public class AddressFactory {

    private AddressFactory() {
    }

    public static Address getAddress(String postalAddress, String physicalAddress, String postalCode) {
        Address address = new Address();
        address.setPostalAddress(postalAddress);
        address.setPhysicalAddress(physicalAddress);
        address.setPostalCode(postalCode);
        return address;
    }
}
